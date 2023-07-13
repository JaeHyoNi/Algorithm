from itertools import combinations_with_replacement
n = int(input())
for _ in range(n):
    N = int(input())
    L, E = sorted(list(map(int, input().split()))), set()
    for i in range(N):
        E.add(L[i])
        for j in range(i+1, N):
            E.add(L[j] - L[i])
    A, L = 0, set(L)
    for a, b, c in list(combinations_with_replacement(list(E), 3)):
        tmp = set([a, b, c, a+b, a+c, b+c, a+b+c])
        if len(L - tmp) == 0: A += 1
    print(A)