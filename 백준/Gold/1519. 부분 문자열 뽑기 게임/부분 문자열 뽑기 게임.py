import sys
sys.setrecursionlimit(10**7)
N = int(input())
V = [0] * 10 + [-1] * N
def Dp(n, F):
    if V[n] != -1: return V[n]
    s, l, V[n], A = str(n), len(str(n)), 0, 1e9
    for i in range(l):
        for j in range(i+1, l+1):
            k = n % 10 ** j // 10 ** i
            if k == 0 or k == n: continue
            if Dp(n-k, 0) == 0:
                V[n] = 1
                if F: A = min(A, k)
                else: return 1
    if F: return -1 if A > 1e8 else A
    return 0
A = Dp(N, True)
print(A if A else -1)