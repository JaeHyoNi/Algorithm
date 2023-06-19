S = input()
arr, m, A, V, nS, li = [0] * len(S), dict(), -1, 0,  0, [0] * len(S)
for n, i in enumerate(S):
    if i == 'S': V, nS = V + 2, nS + 1
    elif i == 'K': V -= 1
    li[n] = nS
    if V not in m:
        m[V] = n
    if V == 0 and li[n] > 0:
        A = max(A, n+1)
    if V in m and li[n] - li[m[V]] > 0:
        A = max(A, n - m[V])
print(A)
