arr = [list(map(int, input().split())) for _ in range(10)]
use = [0, 5, 5, 5, 5, 5]
def check(x, y):
    for k in range(1, 5):
        for i in range(k + 1):
            if x + k >= 10 or y + i >= 10 or x + i >= 10 or y + k >= 10 or arr[x + k][y + i] == 0 or arr[x + i][y + k] == 0:
                return k
    return 5

def dfs(x, dep):
    global ans
    if dep >= ans:
        return
    flag = True
    for i in range(x, 10):
        for j in range(10):
            if arr[i][j] == 1:
                flag = False
                tmp = check(i, j)
                for T in range(tmp, 0, -1):
                    if use[T] <= 0: continue
                    use[T] -= 1
                    for k in range(T):
                        for t in range(T):
                            arr[i + k][j + t] = 0
                    dfs(i, dep + 1)
                    for k in range(T):
                        for t in range(T):
                            arr[i + k][j + t] = 1
                    use[T] += 1
                return
    if flag:
        ans = min(ans, dep)
ans = 9999999
dfs(0, 0)
print(-1 if ans == 9999999 else ans)