#include <bits/stdc++.h>
using namespace std;
// <거리 , 시작지점>
pair<int,int> cache[50001];
vector<vector<pair<int,int>>> roads;
vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    vector<int> answer;
    roads.resize(n+1);
    //출발지는 -1로 표시
    for(auto K : gates){cache[K].first = -1;}
    //봉우리는 -2로 표시
    for(auto K : summits){cache[K].first = -2;}
    sort(summits.begin(),summits.end());
    for(auto K:paths){roads[K[0]].push_back({K[1] ,K[2]}); roads[K[1]].push_back({K[0],K[2]});}
    int MIN_bong;
    int MIN = INT_MAX;
    int des,from,val;
    for(auto K:summits){
        queue<int> wait;    wait.push(K);
        while(!wait.empty()){
            from = wait.front(); wait.pop();
            for(auto J: roads[from]){
                des = J.first , val = J.second;
                //만약 현재까지의 답보다 크다면 컨틴유
                if(val >= MIN){continue;}
                //방문한곳이 봉우이라면 컨틴유
                if(cache[des].first == -2){continue;}
                //출발, 도착지라면 답 업데이트
                else if(cache[des].first == -1){
                    if(MIN > max(val,cache[from].first)){ 
                        MIN = max(val,cache[from].first);
                        MIN_bong = K;
                    }
                    continue;
                }
                //목적지에 저장된 캐시값이 더 작으면 컨틴유
                else if(cache[des].first <= max(val,cache[from].first) && cache[des].first != 0){continue;}
                //아니라면 방문하고 값을 저장함
                else{
                    cache[des] = {max(val,cache[from].first),K};
                    wait.push(des);
                }
            }
        }
    }
    answer.push_back(MIN_bong);
    answer.push_back(MIN);
    return answer;
}