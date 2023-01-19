string = list(input())
dp = [[-1 for _ in range(len(string))] for _ in range(len(string))]


def solve(left, right):
    if dp[left][right] != -1: return dp[left][right]
    if left >= right: return 0
    if string[left] == string[right]: return solve(left+1, right-1)
    dp[left][right] = min(solve(left+1, right) + 1, solve(left, right-1) + 1, solve(left+1, right-1) + (1 if string[left] != string[right] else 0))
    return dp[left][right]


answer = 999999
answer = min(answer, solve(0, len(string)-1))
for i in range(len(string)):
    for j in range(i, len(string)):
        dp = [[-1 for _ in range(len(string))] for _ in range(len(string))]
        string[i], string[j] = string[j], string[i]
        answer = min(answer, solve(0, len(string)-1)+1)
        string[i], string[j] = string[j], string[i]
print(answer)