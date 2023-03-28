T, W = map(int, input().split())
arr = [int(input())-1 for _ in range(T)]
dp = [[[0 for _ in range(2)] for _ in range(T)] for _ in range(W+1)]
if arr[0] == 0: dp[0][0][0] = 1
else: dp[1][0][1] = 1

for i in range(1, T):
    for C in range(W+1):
        for pre in range(2):
            if arr[i] == pre:
                dp[C][i][pre] = max(dp[C][i-1][pre] + 1, dp[C][i][pre])
            else:
                if C < W:
                    dp[C+1][i][arr[i]] = max(dp[C][i-1][pre]+1, dp[C+1][i][arr[i]])
                dp[C][i][pre] = max(dp[C][i][pre], dp[C][i-1][pre])
ans = 0
for i in range(T):
    for j in range(W+1):
        for k in range(2):
            ans = max(ans, dp[j][i][k])
print(ans)