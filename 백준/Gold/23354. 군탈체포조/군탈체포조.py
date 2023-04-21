from heapq import heappush, heappop
from itertools import permutations
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dx, dy, V, n = [-1, 0, 1, 0], [0, 1, 0, -1], {}, 0
for i in range(N):
    for j in range(N):
        if arr[i][j] in [0, -1]:
            V[(i, j)], arr[i][j] = n, 0
            n += 1
dis = [[1e10] * (n) for _ in range(n)]
for a, b in V:
    pq = [(0, a, b)]
    num, tmp = dis[V[(a, b)]].count(1e10), [[1e10] * N for _ in range(N)]
    while pq:
        v, x, y = heappop(pq)
        if tmp[x][y] < v: continue
        if (x, y) in V and dis[V[(a, b)]][V[(x, y)]] == 1e10:
            dis[V[(a, b)]][V[(x, y)]] = dis[V[(x, y)]][V[(a, b)]] = v
            num -= 1
            if num == 0: break
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N or tmp[nx][ny] <= v + arr[nx][ny]: continue
            tmp[nx][ny] = v + arr[nx][ny]
            heappush(pq, (tmp[nx][ny], nx, ny))
ans = 1e10
for li in list(permutations([i for i in range(1, n)])):
    li, tmp = [0] + list(li) + [0], 0
    for k in range(n):
        tmp += dis[li[k]][li[k+1]]
    ans = min(ans, tmp)
print(ans)

