from math import gcd
x, y = map(int, input().split())
n = x * y
t = int((n) ** 0.5) + 1
for i in range(t, 0, -1):
    if n % i != 0: continue
    if gcd(i, n // i) == x:
        print(min(n // i, i), max(n // i, i))
        exit(0)