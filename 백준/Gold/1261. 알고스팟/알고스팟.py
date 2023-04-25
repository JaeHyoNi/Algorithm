from collections import deque
N, M = map(int, input().split())
arr, ans = [list(map(int, list(input()))) for _ in range(M)], 0
que0, que1 = deque([(0, 0)]), deque()
dx, dy, arr[0][0] = [-1, 0, 1, 0], [0, 1, 0, -1], -1
flip = False
while True:
    while que0:
        x, y = que0.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= M or ny < 0 or ny >= N or arr[nx][ny] == -1: continue
            if arr[nx][ny] == 0: que0.append((nx, ny))
            else: que1.append((nx, ny))
            arr[nx][ny] = -1
    if arr[M-1][N-1] == -1: break
    que0.extend(que1)
    que1.clear()
    ans += 1
print(ans)