N = int(input())
L = [list(map(int, input().split())) for _ in range(N)]
A = [[[int(1e10)] * 3 for _ in range(N)] for _ in range(3)]
A[0][0][0], A[1][0][1], A[2][0][2] = L[0]
O = [(0, 1, 2), (1, 0, 2), (2, 0, 1)]
for i in range(1, N):
    for k in range(3):
        for a, b, c in O: A[k][i][a] = min(A[k][i-1][b], A[k][i-1][c]) + L[i][a]
print(min(A[0][N-1][1], A[0][N-1][2],A[1][N-1][0], A[1][N-1][2],A[2][N-1][0], A[2][N-1][1]))