N = int(input())
mp, mf, ms, mv = map(int, input().split())
arr = [tuple(map(int, input().split())) for _ in range(N)]
ans = float('inf')
ansli = []
def DFS(i, p, f, s, v, c, li):
    global ans, ansli
    if p >= mp and f >= mf and s >= ms and v >= mv and c < ans:
        ans = c
        ansli = li
        return
    if c >= ans or i >= N:
        return
    DFS(i+1, p+arr[i][0], f + arr[i][1], s + arr[i][2], v + arr[i][3], c + arr[i][4], li + [i])
    DFS(i+1, p, f, s, v, c, li)

DFS(0, 0, 0, 0, 0, 0, [])
if ans == float('inf'):
    print(-1)
else:
    print(ans)
    for i in ansli:
        print(i+1, end=' ')