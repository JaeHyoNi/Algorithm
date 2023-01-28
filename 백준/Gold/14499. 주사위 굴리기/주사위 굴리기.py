dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
dice = [0, 0, 0, 0, 0, 0]
# 0:동, 1:서, 2:남, 3:북
def dice_move(i):
    if i == 0:
        dice[1], dice[3], dice[4], dice[5] = dice[4], dice[5], dice[3], dice[1]
    elif i == 1:
        dice[1], dice[3], dice[4], dice[5] = dice[5], dice[4], dice[1], dice[3]
    elif i == 2:
        dice[0], dice[1], dice[2], dice[3] = dice[3], dice[0], dice[1], dice[2]
    elif i == 3:
        dice[0], dice[1], dice[2], dice[3] = dice[1], dice[2], dice[3], dice[0]


N, M, x, y, K = map(int, input().split())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))
order = list(map(int, input().split()))
for i in range(len(order)): order[i] -= 1


for i in order:
    nx, ny = x + dx[i], y + dy[i]
    if 0 <= nx < N and 0 <= ny < M:
        dice_move(i)
        if arr[nx][ny] == 0:
            arr[nx][ny] = dice[1]
        else:
            dice[1] = arr[nx][ny]
            arr[nx][ny] = 0
        x, y = nx, ny
        print(dice[3])


