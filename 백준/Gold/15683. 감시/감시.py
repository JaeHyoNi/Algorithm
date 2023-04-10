from collections import deque
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
camera = []
for i in range(N):
    for j in range(M):
        if arr[i][j] not in [0, 6]:
            camera.append((int(arr[i][j]), i, j))
def CCTV(x, y, d):
    visit = []
    x, y = x + dx[d], y + dy[d]
    while 0 <= x < N and 0 <= y < M:
        if arr[x][y] == 0:
            visit.append((x, y))
            arr[x][y] = 9
        elif arr[x][y] == 6:
            break
        x, y = x + dx[d], y + dy[d]
    return visit

def back(visit):
    if not visit: return []
    for x, y in visit:
        arr[x][y] = 0
    return []

def dfs(index, count):
    global ans, siz
    if index == len(camera):
        ans = min(siz - count, ans)
        return
    n, x, y = camera[index]
    d = 0
    visit = []
    if n == 1:
        for d in range(4):
            visit.extend(CCTV(x, y, d))
            dfs(index + 1, count + len(visit))
            visit = back(visit)
    elif n == 2:
        for d1, d2 in ((1, 3), (0, 2)):
            visit.extend(CCTV(x, y, d1))
            visit.extend(CCTV(x, y, d2))
            dfs(index + 1, count + len(visit))
            visit = back(visit)
    elif n == 3:
        for d1, d2 in ((0, 1), (1, 2), (2, 3), (3, 0)):
            visit.extend(CCTV(x, y, d1))
            visit.extend(CCTV(x, y, d2))
            dfs(index + 1, count + len(visit))
            visit = back(visit)
    elif n == 4:
        for d1, d2, d3 in ((0, 1, 2), (1, 2, 3), (2, 3, 0), (3, 0, 1)):
            visit.extend(CCTV(x, y, d1))
            visit.extend(CCTV(x, y, d2))
            visit.extend(CCTV(x, y, d3))
            dfs(index + 1, count + len(visit))
            visit = back(visit)
    elif n == 5:
        visit.extend(CCTV(x, y, 0))
        visit.extend(CCTV(x, y, 1))
        visit.extend(CCTV(x, y, 2))
        visit.extend(CCTV(x, y, 3))
        dfs(index + 1, count + len(visit))
        visit = back(visit)
siz = 0
for i in arr:
    siz += i.count(0)
ans = 99999999
dfs(0, 0)
print(ans)

