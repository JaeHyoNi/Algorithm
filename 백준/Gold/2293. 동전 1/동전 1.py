N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]
dp = [0 for _ in range(M+1)]
for k in arr:
    if k <= M:
        dp[k] += 1
    for i in range(M+1):
        if i + k > M:
            break
        dp[i + k] += dp[i]
print(dp[M])
