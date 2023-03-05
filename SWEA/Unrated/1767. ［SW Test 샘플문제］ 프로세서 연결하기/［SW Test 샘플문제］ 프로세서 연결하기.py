T = int(input())
N, max_core, min_val, core_num = 0, 0, 0, 0
arr = []
core = []
# 코어 인덱스, 코어 개수, 값
def DFS(ind, num, val):
    global N, max_core, min_val, core_num
    if max_core < num:
        min_val = val
        max_core = num
    if max_core == num:
        min_val = min(val, min_val)
    if ind == core_num:
        return
    x, y = core[ind]
    # 표면 부분이라 이미 연결되었을 떄
    if core[ind][0] == 0 or core[ind][0] == N-1 or core[ind][1] == 0 or core[ind][1] == N-1:
        DFS(ind+1, num+1, val)
        return
    # 상
    flag = True
    for i in range(x):
        if arr[i][y] == 1:
            flag = False
            break
    if flag:
        for i in range(x):
            arr[i][y] = 1
        DFS(ind+1, num+1, val+x)
        for i in range(x):
            arr[i][y] = 0
    # 하
    flag = True
    for i in range(x+1, N):
        if arr[i][y] == 1:
            flag = False
            break
    if flag:
        for i in range(x+1, N):
            arr[i][y] = 1
        DFS(ind + 1, num + 1, val + (N-x-1))
        for i in range(x+1, N):
            arr[i][y] = 0
    # 좌
    flag = True
    for j in range(y):
        if arr[x][j] == 1:
            flag = False
            break
    if flag:
        for j in range(y):
            arr[x][j] = 1
        DFS(ind + 1, num + 1, val + y)
        for j in range(y):
            arr[x][j] = 0
    # 우
    flag = True
    for j in range(y+1, N):
        if arr[x][j] == 1:
            flag = False
            break
    if flag:
        for j in range(y+1, N):
            arr[x][j] = 1
        DFS(ind + 1, num + 1, val + (N-1-y))
        for j in range(y+1, N):
            arr[x][j] = 0
    # 연결안함
    DFS(ind+1, num, val)

for tc in range(1, T+1):
    core = []
    N, max_core, min_val, core_num = int(input()), 0, 0, 0
    arr = [list(map(int, input().split())) for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 1:
                core.append((i, j))
    core_num = len(core)
    DFS(0, 0, 0)
    print('#{} {}'.format(tc, min_val))