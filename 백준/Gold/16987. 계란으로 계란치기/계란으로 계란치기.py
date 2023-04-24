N = int(input())
arr, ans = [list(map(int, input().split())) for _ in range(N)], 0
def dfs(i, hit):
    global ans
    ans = max(ans, hit)
    if i == N: return
    if arr[i][0] <= 0:
        dfs(i+1, hit)
        return
    for j in range(N):
        if i == j or arr[j][0] <= 0: continue
        arr[j][0] -= arr[i][1]
        arr[i][0] -= arr[j][1]
        tmp = 0
        if arr[i][0] <= 0: tmp += 1
        if arr[j][0] <= 0: tmp += 1
        dfs(i+1, hit + tmp)
        arr[j][0] += arr[i][1]
        arr[i][0] += arr[j][1]
dfs(0, 0)
print(ans)
