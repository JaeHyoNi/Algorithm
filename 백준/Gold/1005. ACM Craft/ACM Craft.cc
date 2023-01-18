#include <bits/stdc++.h>
using namespace std;
int main(){
    int T,N,K,from,to,target,now;
    int planet_time[1001] = {0,}; 
    scanf("%d",&T);
    for(int i=0;i<T;i++){
        scanf("%d %d",&N,&K);
        int planet[1001] = {0,}; 
        vector<int> road[1001];
        vector<int> answer(N+1,0);
        int visit[1001] = {0,};
        for(int i=1;i<=N;i++) scanf("%d",&planet_time[i]);
        for(int i=0;i<K;i++){
            scanf("%d %d",&from,&to);
            planet[to]  ++;
            road[from].push_back(to);
        }
        scanf("%d",&target);
        queue<int> wait;
        for(int i=1;i<=N;i++){
            if(planet[i] == 0){
                wait.push(i); 
                answer[i] = planet_time[i]; 
                visit[i] = 1;
            }
        }
        vector<int> temp;
        while(!wait.empty()){
            now = wait.front();
            temp.push_back(now);
            wait.pop();
            for(auto K:road[now]){
                planet[K]--;
                answer[K] = max( answer[K] , planet_time[K] + answer[now] );
            }
            for(int i=1;i<=N;i++){
                if(visit[i] == 0 && planet[i] == 0){
                    wait.push(i);
                    visit[i] = 1;
                }
            }
        }
        printf("%d\n",answer[target]);
    }
}