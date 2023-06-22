H, W = map(int, input().split())
A = list(map(int, input().split()))
a1, a2, a3 = [A[0]] + [0]*(W-1),[0]*(W-1) + [A[-1]], [0]*W
for i in range(1, W):
    a1[i] = max(a1[i-1], A[i])
    a2[W-1-i] = max(a2[W-i], A[W-1-i])
for i in range(W): a3[i] = min(a1[i], a2[i])
print(sum(a3) - sum(A))
