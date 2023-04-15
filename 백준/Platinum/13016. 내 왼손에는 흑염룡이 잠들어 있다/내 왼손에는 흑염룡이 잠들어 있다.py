from collections import deque
N = int(input())
R = [[] for _ in range(N+1)]
for _ in range(N-1):
    f, t, v = map(int, input().split())
    R[f].append((t, v))
    R[t].append((f, v))
ans = [0] * (N+1)
s = 1
for _ in range(3):
    v = [-1] *(N+1)
    wait, v[s] = deque([(s, 0)]), 0
    while wait:
        n, w = wait.popleft()
        for t, tv in R[n]:
            if v[t] != -1: continue
            v[t] = w + tv
            wait.append((t, w+tv))
            ans[t] = max(ans[t], w+tv)
    s = v.index(max(v))
for i in range(1, N+1): print(ans[i])