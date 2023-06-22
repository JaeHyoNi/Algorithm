from itertools import accumulate
from collections import Counter
import math
t = int(input())
for _ in range(t):
    ans = 0
    T, n = map(int, input().split())
    li = list(accumulate(list(map(int, input().split()))))
    for i in range(len(li)): li[i] = li[i] % T
    count = Counter(li)
    for i, v in count.items():
        ans += math.comb(v, 2)
    ans += count[0]
    print(ans)