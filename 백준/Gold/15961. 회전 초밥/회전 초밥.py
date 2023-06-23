from collections import defaultdict
import sys
input = sys.stdin.readline
N, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(N)]
cache = defaultdict(int)
for i in range(k): cache[arr[i]] += 1
ans = len(cache)
for i in range(N):
    cache[arr[i]] -= 1
    if cache[arr[i]] == 0:
        del cache[arr[i]]
    n = (i + k) % N
    cache[arr[n]] += 1
    if not c in cache: ans = max(ans, len(cache) + 1)
    else: ans = max(ans, len(cache))
print(ans)