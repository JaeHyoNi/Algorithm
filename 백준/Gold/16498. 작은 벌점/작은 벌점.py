from bisect import bisect_left
N = list(map(int, input().split()))
L, A = [list(sorted(list(map(int, input().split())))) for _ in range(3)], 1e10
for s, e, t in [(0, 1, 2), (1, 2, 0), (0, 2, 1)]:
    for i in L[s]:
        for j in L[e]:
            a, b = min(i,j), max(i, j)
            S, E = bisect_left(L[t], a), bisect_left(L[t], b)
            if E == N[t] or L[t][E] > b: E-=1
            if E - S >= 0: A = min(A, b-a)
print(A)
