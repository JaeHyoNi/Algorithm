N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]
dp = [100001 for _ in range(M+1)]
dp[0] = 0
for k in arr:
    for i in range(k, M+1):
        dp[i] = min(dp[i], dp[i-k] + 1)
if dp[M] == 100001:
    print(-1)
else:
    print(dp[M])