N = int(input())
arr = [list(map(int, list(input()))) for _ in range(N)]
dp = [[[False for _ in range(10)] for _ in range(1 << N)] for _ in range(N)]
answer = 0
def dfs(pre, visited, val, num):
    global answer
    for i in range(1, N):
        next_visit, next_val = visited | (1<<i), arr[pre][i]
        if visited & (1<<i) > 0 or next_val < val or dp[i][next_visit][next_val]: continue
        dp[i][next_visit][next_val] = True
        dfs(i, next_visit, next_val, num+1)
        answer = max(answer, num+1)
dfs(0, 1, 0, 1)
print(answer)