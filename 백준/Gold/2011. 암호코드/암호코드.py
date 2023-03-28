encode = list(map(int, list(input())))
siz = len(encode)
dp = [0 for _ in range(siz+1)]
dp[-1] = dp[-2] = 1
if encode[-1] == 0:
    dp[-2] = 0
for i in range(siz-2, -1, -1):
    if encode[i] == 0:
        dp[i] = 0
    elif encode[i]*10 + encode[i+1] <= 26:
        dp[i] += (dp[i+2] + dp[i+1])
    else:
        dp[i] = dp[i+1]
    if dp[i] > 1000000:
        dp[i] = dp[i] % 1000000
print(dp[0])