N, M = map(int, input().split())
arr = [[0] * (M + 1)] + [[0] + list(map(int, input().split())) for _ in range(N)]
for i in range(1, N+1):
    for j in range(1, M+1):
            arr[i][j] += arr[i][j-1]
for i in range(1, N+1):
    for j in range(1, M+1):
            arr[i][j] += arr[i-1][j]
ans = -100001
for x in range(1, N+1):
    for y in range(1, M+1):
        for xx in range(x, N+1):
            for yy in range(y, M+1):
                ans = max(ans, arr[xx][yy] + arr[x-1][y-1] - arr[x-1][yy] - arr[xx][y-1])
print(ans)
