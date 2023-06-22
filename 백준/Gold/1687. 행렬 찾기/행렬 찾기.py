N, M = map(int, input().split())
arr = [list(map(int, list(input()))) for _ in range(N)]
tmp,A = [[0]*(M+1) for _ in range(N+1)], 0
for i in range(1, N+1):
    for j in range(1, M+1):
        if arr[i-1][j-1] == 0:
            tmp[i][j] = tmp[i][j-1]+1
for i in range(1, N+1):
    for j in range(1, M+1):
        if tmp[i][j] == 0: continue
        v, r, c = tmp[i][j], 1, i
        while c <= N:
            v = min(tmp[c][j], v)
            if v == 0: break
            A = max(A, v * r)
            r, c = r + 1, c + 1
print(A)