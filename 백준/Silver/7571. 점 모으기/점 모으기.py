N, M = map(int, input().split())
x, y, point = [], [],[]
for _ in range(M):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)
    point.append((a,b))
x = sorted(x)
y = sorted(y)
a, b = x[int(M/2)], y[int(M/2)]
sum =0
for i, j in point:
    sum += (abs(a-i)+abs(b-j))
print(sum)