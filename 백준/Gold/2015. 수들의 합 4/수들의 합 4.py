from collections import defaultdict
N, K = map(int, input().split())
arr = list(map(int, input().split()))
for i in range(N-1):
    arr[i+1] = arr[i] + arr[i+1]
dic = defaultdict(int)
for i in arr:
    dic[i] += 1
ans = 0
if K in dic: ans += dic[K]
for i in arr:
    dic[i] -= 1
    if K+i in dic: ans += dic[K+i]
print(ans)