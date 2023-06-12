from math import gcd
N, M, K = map(int, input().split())
ans = 0
for x1 in range(N+1):
    for y1 in range(M+1):
        for x2 in range(N+1):
            for y2 in range(M+1):
                if gcd(abs(x2 - x1), abs(y2 - y1)) == K - 1:
                    ans += 1
print(ans // 2)
