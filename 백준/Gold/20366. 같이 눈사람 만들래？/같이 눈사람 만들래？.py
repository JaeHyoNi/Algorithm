N = int(input())
arr = sorted(list(map(int, input().split())))
A = 1e10
for i in range(N-3):
    for j in range(i+3, N):
        L, R = i+1, j-1
        s = arr[i] + arr[j]
        while L < R:
            t = arr[L] + arr[R]
            A = min(abs(t-s), A)
            if t > s: R -= 1
            else: L += 1
print(A)