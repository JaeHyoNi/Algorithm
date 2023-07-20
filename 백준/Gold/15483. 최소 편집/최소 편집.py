s1, s2 = input(), input()
N, M = len(s1), len(s2)
arr = [[0 for _ in range(M+1)] for _ in range(N + 1)]
for i in range(N + 1): arr[i][0] = i
for i in range(M + 1): arr[0][i] = i

for i in range(1, N+1):
    for j in range(1, M+1):
        if s1[i-1] == s2[j-1]:
            arr[i][j] = arr[i-1][j-1]
        else:
            arr[i][j] = min(arr[i-1][j] + 1, arr[i][j-1] + 1, arr[i-1][j-1] + 1)
print(arr[N][M])


