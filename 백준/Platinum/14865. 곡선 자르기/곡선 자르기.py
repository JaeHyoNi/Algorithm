N = int(input())
fx, fy = 9999999,9999999
arr = dict()
ord = []
str = []
first = 0
flag = False
point = []
for i in range(N):
    t1, t2 = map(int, input().split())
    point.append((t1, t2))
    if t1 < fx:
        fx = t1
        fy = t2
        first = i
    elif t1 == fx:
        if t2 < fy:
            fy = t2
            first = i
px, py = fx, fy
tmp = 0
for i in range(first, first+N):
    x, y = point[i%N]
    if py * y >= 0:
        px = x
        py = y
        continue
    if not flag:
        flag = True
        ord.append(x)
        tmp = x
    elif flag:
        if x > tmp:
            arr[x] = ')'
            arr[tmp] = '('
        else:
            arr[x] = '('
            arr[tmp] = ')'
        ord.append(x)
        flag = False
    px = x
    py = y

for i in sorted(ord):
    str.append(arr[i])
a, b, tmp = 0, 0, 0
k = len(str)
for i in range(k):
    if str[i] == '(':
        tmp += 1
        if str[i+1] == ')':
            b += 1
    else:
        if tmp == 1:
            a += 1
        tmp -= 1
print(a, b)
