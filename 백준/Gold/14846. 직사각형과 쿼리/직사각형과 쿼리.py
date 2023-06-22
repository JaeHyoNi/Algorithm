N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[[0] * 10 for _ in range(N+1)] for _ in range(N+1)]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        dp[i][j][arr[i-1][j-1]-1] += 1
        for k in range(10):
            dp[i][j][k] += (dp[i-1][j][k]+dp[i][j-1][k]-dp[i-1][j-1][k])
for _ in range(int(input())):
    A = 0
    x1, y1, x2, y2 = map(int, input().split())
    for k in range(10):
        if dp[x2][y2][k] + dp[x1-1][y1-1][k] - dp[x1-1][y2][k] - dp[x2][y1-1][k] > 0:
            A += 1
    print(A)