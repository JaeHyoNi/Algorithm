from itertools import product
from collections import deque
direct = tuple(product([0, 1, 2, 3], repeat=3))
dx, dy = [0, -1, -1, -1, 0, 1, 1, 1], [-1, -1, 0, 1, 1, 1, 0, -1]
prior = [2, 0, 6, 4]
N, M = map(int, input().split())
fish = [list(map(int, input().split())) for _ in range(N)]
shark = list(map(int, input().split()))
smell = [[0 for _ in range(4)] for _ in range(4)]
shark = [shark[0]-1, shark[1]-1]
arr = [[deque() for _ in range(4)] for _ in range(4)]
tmparr = [[[] for _ in range(4)] for _ in range(4)]

for i in range(N):
    fish[i] = (fish[i][0]-1, fish[i][1]-1, fish[i][2]-1)
    arr[fish[i][0]][fish[i][1]].append(fish[i][2])

for T in range(M):
    for x in range(4):
        for y in range(4):
            for d in arr[x][y]:
                nx, ny, nd = x + dx[d], y + dy[d], d
                flag = 0
                while nx < 0 or nx > 3 or ny < 0 or ny > 3 or (nx == shark[0] and ny == shark[1]) or smell[nx][ny] > T:
                    nd = (nd-1) % 8
                    nx, ny = x + dx[nd], y + dy[nd]
                    flag += 1
                    if flag > 8:
                        nx, ny, nd = x, y, d
                        break
                tmparr[nx][ny].append(nd)
    max_move = -1
    move = ""
    for dir in direct:
        tmp = 0
        imp = False
        visit = []
        nx, ny = shark[0], shark[1]
        for d in dir:
            nx, ny = nx + dx[prior[d]], ny + dy[prior[d]]
            if nx < 0 or nx > 3 or ny < 0 or ny > 3:
                imp = True
                break
            if (nx, ny) not in visit:
                tmp += len(tmparr[nx][ny])
            visit.append((nx, ny))
        if imp:
            continue
        if max_move < tmp:
            max_move = tmp
            move = dir
    for d in move:
        shark[0], shark[1] = shark[0] + dx[prior[d]], shark[1] + dy[prior[d]]
        if len(tmparr[shark[0]][shark[1]]) >= 1:
            smell[shark[0]][shark[1]] = T+3
        tmparr[shark[0]][shark[1]].clear()
    for i in range(4):
        for j in range(4):
            for k in tmparr[i][j]:
                arr[i][j].append(k)
            tmparr[i][j] = []
ans = 0
for i in range(4):
    for j in range(4):
        ans += len(arr[i][j])
print(ans)



