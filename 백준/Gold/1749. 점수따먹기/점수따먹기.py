N, M = map(int, input().split())
a = [[0] * (M + 1)] + [[0] + list(map(int, input().split())) for _ in range(N)]
for i in range(1, N+1):
    for j in range(1, M+1):
            a[i][j] += a[i][j-1]
for i in range(1, N+1):
    for j in range(1, M+1):
            a[i][j] += a[i-1][j]
ans = -100001
for x in range(1, N+1):
    for y in range(1, M+1):
        for xx in range(x, N+1):
            for yy in range(y, M+1):
                ans = max(ans, a[xx][yy] + a[x-1][y-1] - a[x-1][yy] - a[xx][y-1])
print(ans)
