#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> arr(2000, vector<int>());
bool visited[2000], flag;

void dfs(int K, int dep){
    if(dep == 5 || flag) {flag = true; return;}
    for(int i : arr[K]){
        if(visited[i]) continue;
        visited[i] = true;
        if(dep+1 == 5){flag = true; return;}
        dfs(i, dep+1);
        visited[i] = false;
    }
}

int main(){
    int f, t, N, M; scanf("%d %d", &N, &M);
    for(int i=0; i<M; i++){
        scanf("%d %d", &f, &t);
        arr[f].emplace_back(t); arr[t].emplace_back(f);
    }
    for(int i=0; i<N; i++) {
        visited[i] = true;
        if(!flag) dfs(i, 1);
        visited[i] = false;
    }
    if(flag) printf("1");
    else printf("0");
}