N, M, K = map(int, input().split())
arr = [0] * (N+1)
def sum(i):
    tmp = 0
    while i > 0:
        tmp += arr[i]
        i -= (i & -i)
    return tmp
for i in range(1, N+1):
    tmp = int(input())
    while i <= N:
        arr[i] += tmp
        i += (i & -i)
for _ in range(M + K):
    a, b, c = map(int, input().split())
    if a == 1:
        diff = c - (sum(b) - sum(b-1))
        while b <= N:
            arr[b] += diff
            b += (b & -b)
    else:
        print(sum(c) - sum(b-1))
