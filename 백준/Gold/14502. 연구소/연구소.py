from collections import deque

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
safe, virus = [], []
safeNum = 0
ans = 0
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
tx, ty = [-1, -1, 0, 1, 1, 1, 0, -1], [0, 1, 1, 1, 0, -1, -1, -1]
for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            safe.append((i, j))
            safeNum+=1
        elif arr[i][j] == 2:
            virus.append((i, j))


def dfs(ind, dep):
    if dep == 3:
        wait = deque(virus)
        nowsafe = safeNum-3
        visited = set()
        while wait:
            x, y = wait.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if 0<=nx<N and 0<=ny<M and arr[nx][ny] == 0 and (nx, ny) not in visited:
                    visited.add((nx, ny))
                    wait.append((nx, ny))
                    nowsafe-=1
        global ans
        ans = max(ans, nowsafe)
    else:
        for i in range(ind, safeNum):
            x, y = safe[i]
            flag = True
            if dep == 2:
                flag = False
                for t in range(8):
                    nx, ny = x + tx[t], y + ty[t]
                    if 0<=nx<N and 0<=ny<M and arr[nx][ny] != 0:
                        flag = True
                        break
            if flag:
                arr[safe[i][0]][safe[i][1]] = 1
                dfs(i+1, dep+1)
                arr[safe[i][0]][safe[i][1]] = 0

dfs(0, 0)
print(ans)
