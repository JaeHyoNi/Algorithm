from heapq import heappop, heappush
s, target = map(int, input().split())
wait = [[0, s]]
Visited = [False for _ in range(100001)]
while wait:
    val, n = heappop(wait)
    if n == target:
        print(val)
        break
    if n*2 <= 100000 and not Visited[n*2]:
        heappush(wait, [val, n*2])
        Visited[n * 2] = True
    if n-1 >= 0 and not Visited[n-1]:
        heappush(wait, [val+1, n-1])
        Visited[n-1] = True
    if n+1 <= 100000 and not Visited[n+1]:
        heappush(wait, [val + 1, n + 1])
        Visited[n+1] = True

