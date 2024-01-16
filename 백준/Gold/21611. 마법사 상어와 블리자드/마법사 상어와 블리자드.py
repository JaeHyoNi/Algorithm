N, M = map(int, input().split())
L = [list(map(int, input().split())) for _ in range(N)]
x, y, d, D, Q, T = N//2, N//2, 0, [(0, -1), (1, 0), (0, 1), (-1, 0)], [], 0
for r in [i for i in range(1, N) for _ in range(2)] + [N]:
    for _ in range(r):
        if L[x][y] != 0: Q.append(L[x][y])
        L[x][y] = T
        x, y, T = x + D[d][0], y + D[d][1], T+1
    d = (d + 1) % 4
Q = [0] + Q
D, A = [(0, 0), (-1, 0), (1, 0), (0, -1), (0, 1)], 0
for _ in range(M):
    d, r = map(int, input().split())
    x, y, F, n = N//2, N//2, True, []
    for i in range(r):
        x, y = x + D[d][0], y + D[d][1]
        if len(Q) > L[x][y]-i:
            del Q[L[x][y]-i]
        else: break
    while F:
        F, i, n = False, 1, [0]
        while i<len(Q):
            C = 1
            while i + C < len(Q) and Q[i] == Q[i+C]: C+=1
            if C >= 4:
                A += C*(Q[i+C-2])
                del Q[i:i+C]
                F = True
            else:
                n.extend([C, Q[i]])
                i += C
    if len(n) > N*N: Q = n[:N*N]
    else: Q = n
print(A)