#include <bits/stdc++.h>
using namespace std;
int N, dp[5001][5001], L[5000];
int Dp(int s, int e){
    if(s>=e) return 0;
    if(dp[s][e] != -1) return dp[s][e];
    if(L[s]==L[e]) return dp[s][e] = Dp(s+1, e-1);
    return dp[s][e] = min(Dp(s+1, e), Dp(s, e-1)) + 1;
}
int main(){
    cin >> N;
    for(int i=0; i<N; i++) for(int j=0; j<N; j++) dp[i][j] = -1;
    for(int i=0; i<N; i++) cin >> L[i];
    cout << Dp(0, N-1);
}