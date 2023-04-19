N = int(input())
ans, arr = [0] * N, []
for i in range(N):
    n = int(input())
    while arr:
        if n >= arr[-1][1]:
            ans[arr[-1][0]] = i - arr[-1][0] - 1
            arr.pop()
        else: break
    arr.append((i, n))
for i, n in arr:
    ans[i] = N - i - 1
print(sum(ans))