N = int(input())
arr = []
for i in range(N):
    t, p = map(int, input().split())
    arr.append((t, p))
dp = [0 for _ in range(N+1)]
for i, (t, p) in enumerate(arr, start=1 ):
    if i + t - 1 <= N:
        dp[i+t-1] = max(dp[i+t-1], dp[i-1]+p)
    dp[i] = max(dp[i], dp[i-1])
print(max(dp))

