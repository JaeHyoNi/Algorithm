N = int(input())
val = [list(map(int, input().split())) for _ in range(N)]
dp = [[1000001 for _ in range(N)] for _ in range(3)]
for i in range(3):
    dp[i][0] = val[0][i]
for i in range(1, N):
    for j in range(3):
        dp[j][i] = min(dp[(j+1)%3][i-1] + val[i][j], dp[(j-1)%3][i-1] + val[i][j])
print(min(dp[0][N-1], dp[1][N-1], dp[2][N-1]))