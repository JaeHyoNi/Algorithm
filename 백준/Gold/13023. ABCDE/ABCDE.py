N, M = map(int, input().split())
arr = [[] for _ in range(N)]
visited = [False for _ in range(N)]
flag = False
for i in range(M):
    f, t = map(int, input().split())
    arr[f].append(t)
    arr[t].append(f)

def dfs(i, dep):
    global flag
    for k in arr[i]:
        if visited[k]: continue
        visited[k] = True
        if dep==4:
            flag = True
            return
        dfs(k, dep+1)
        visited[k] = False

for i in range(N):
    visited[i] = True
    dfs(i, 1)
    if flag: break
    visited[i] = False

if flag: print(1)
else: print(0)