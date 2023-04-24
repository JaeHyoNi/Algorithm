from collections import deque
N, M = map(int, input().split())
arr = [list(map(int, list(input()))) for _ in range(N)]
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
ans, a = 0, 1
wait = deque()
for i in range(N):
    for j in range(M):
        if arr[i][j] == 2:
            wait.append((i, j))
            arr[i][j] = -1
while wait:
    siz = len(wait)
    for _ in range(siz):
        if not wait: break
        x, y = wait.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M or arr[nx][ny] == 1 or arr[nx][ny] == -1: continue
            if arr[nx][ny] in [3, 4, 5]:
                a = 0
                wait.clear()
                break
            else:
                wait.append((nx, ny))
                arr[nx][ny] = -1
    ans += 1
    if a == 0: break
print("TNAIKE"[a::2])
if a == 0 : print(ans)