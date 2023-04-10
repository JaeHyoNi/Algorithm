R, C, N = map(int, input().split())
arr = [list(input()) for _ in range(R)]
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
def do():
    bomb = []
    for i in range(R):
        for j in range(C):
            if arr[i][j] == 'O':
                bomb.append((i, j))
            arr[i][j] = 'O'
    for x, y in bomb:
        arr[x][y] = '.'
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < R and 0 <= ny < C:
                arr[nx][ny] = '.'
if N % 2 == 0:
    for i in range(R):
        for j in range(C):
            arr[i][j] = 'O'
else:
    if N >= 3:
        if (N - 3) % 4 == 0:
            do()
        else:
            do()
            do()
for i in arr:
    print(''.join(i))
