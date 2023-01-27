from collections import deque
direct = {'U' : 0, 'R' : 1, 'D' : 2,  'R' : 3}
dx, dy = [-1, 0, 1, 0] , [0, 1, 0, -1]
N = int(input())
M = int(input())
arr = [[0 for _ in range(N)] for _ in range(N)]
arr[0][0] = 2
for _ in range(M):
    x, y = map(int,input().split())
    arr[x-1][y-1] = 1
M = int(input())
snake = deque()
snake.append((0, 0))
move = []
for _ in range(M):
    t, d = input().split()
    move.append((int(t), d))
answer = 0
nowdir = 1
x, y = 0, 0
turn_index = 0
while(1):
    if turn_index < M and answer == move[turn_index][0]:
        if move[turn_index][1] == 'D': nowdir = (nowdir+1)%4
        else: nowdir = (nowdir-1)%4
        turn_index += 1
    nx, ny = x + dx[nowdir], y+dy[nowdir]
    if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] != 2:
        if arr[nx][ny] != 1:
            tx, ty = snake.popleft()
            arr[tx][ty] = 0
        arr[nx][ny] = 2
        x, y = nx, ny
        snake.append((nx, ny))
    else: break
    answer += 1
print(answer+1)


