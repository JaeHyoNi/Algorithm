#include <bits/stdc++.h>
using namespace std;

int solution(int alp, int cop, vector<vector<int>> problems) {
    int answer = INT_MAX;
    int algo_max=0 , cop_max=0 , temp;
    for(auto K:problems){
        algo_max = max(algo_max, K[0]);
        cop_max = max(cop_max , K[1]);
    }
    if(algo_max < alp) alp = algo_max;
    if(cop_max < cop) cop = cop_max;
    answer = algo_max - alp + cop_max - cop;
    int arr[151][151];
    for(int i=alp; i<=algo_max;i++){
        for(int j=cop;j<=cop_max;j++){
            arr[i][j] = i-alp + j-cop;
        }
    }
    for(int i=alp;i<=algo_max;i++){
        for(int j=cop;j<=cop_max;j++){
            int x = i,y = j;
            for(auto K:problems){
                if(x < K[0] || y < K[1]){continue;}
                int a = x+K[2] , b = y+K[3] , val = K[4] + arr[x][y];
                if(a >= algo_max) a = algo_max;
                if(b >= cop_max) b = cop_max;
                if(arr[a][b] <= val) continue;
                arr[a][b] = val;
                temp = algo_max - a + cop_max - b;
                answer = min(answer , val + temp);
            }
        }
    }
    return answer;
}