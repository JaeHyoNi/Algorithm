#include <bits/stdc++.h>
using namespace std;
int N,S,ans;
int arr[20];
void dfs(int i, int sum) {
    if (i == N) return;
    if (sum+arr[i] == S) {
        ans = ans + 1;
    }
    dfs(i+1, sum);
    dfs(i+1, sum + arr[i]);
}

int main() {
    scanf("%d %d", &N, &S);
    for (int i=0;i<N;i++) scanf("%d", &arr[i]);
    dfs(0, 0);
    printf("%d\n", ans);
    return 0;
}