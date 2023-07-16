import sys
import heapq
input = sys.stdin.readline
mod = int(1e9) + 7
for _ in range(int(input())):
    n = int(input())
    ls = list(map(int, input().split()))
    ans = 1
    heapq.heapify(ls)
    for _ in range(n - 1):
        k = heapq.heappop(ls) * heapq.heappop(ls)
        heapq.heappush(ls, k)
        ans *= k % mod
    print(ans % mod)