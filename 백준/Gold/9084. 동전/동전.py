T = int(input())
for t in range(T):
    N = int(input())
    arr = list(map(int, input().split()))
    target = int(input())
    dp = [0 for _ in range(20001)]
    for k in arr:
        dp[k] += 1
        for i in range(target+1):
            dp[i + k] += dp[i]
    print(dp[target])