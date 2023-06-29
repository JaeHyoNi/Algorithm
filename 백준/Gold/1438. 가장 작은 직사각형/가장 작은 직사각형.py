from itertools import combinations_with_replacement
N = int(input())
ps = [tuple(map(int, input().split())) for _ in range(N)]
Y, N, A = sorted(list(set(p[1] for p in ps))), N//2, 1e10
for y1, y2 in list(combinations_with_replacement(Y, 2)):
    tmp = sorted([p[0] for p in ps if y1 <= p[1] <= y2])
    if len(tmp) >= N:
        for i in range(len(tmp) - N + 1):
            A = min(A, (y2 - y1 + 2) * (tmp[i+N-1] - tmp[i] + 2))
print(A)
