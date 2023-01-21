N = int(input())
arr = [list(map(int, list(input()))) for _ in range(N)]
dp = [[[False for _ in range(10)] for _ in range(1<<N)] for _ in range(N)]
answer = 0

# 이전 방문한곳 / 방문기록 / 현재 그림 가격 / 사람 명수
def dfs(pre, visited, val, num):
    global answer
    for i in range(1, N):
        next_visit = visited | (1<<i)
        if visited & (1<<i) > 0 or arr[pre][i] < val or dp[i][next_visit][arr[pre][i]]:
            continue
        else:
            dp[i][next_visit][arr[pre][i]] = True
            dfs(i, next_visit, arr[pre][i], num+1)
            answer = max(answer, num+1)

dfs(0, 1, 0, 1)
print(answer)