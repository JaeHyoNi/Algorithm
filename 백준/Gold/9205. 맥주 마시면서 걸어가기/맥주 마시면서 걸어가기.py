from collections import deque
t = int(input())
for T in range(1, t+1):
    N = int(input())
    tmp = list(tuple(map(int, input().split())) for _ in range(N+2))
    siz = len(tmp)
    con = [[] for _ in range(siz)]
    for i in range(siz):
        for j in range(i):
            if abs(tmp[i][0] - tmp[j][0]) + abs(tmp[i][1] - tmp[j][1]) > 1000: continue
            con[i].append(j)
            con[j].append(i)
    visit = [True] + [False for _ in range(siz-1)]
    wait = deque([0])
    flag = True
    while wait and flag:
        n = wait.popleft()
        for i in con[n]:
            if visit[i]: continue
            if i == siz-1:
                flag = False
                break
            visit[i] = True
            wait.append(i)
    print("sad" if flag else "happy")