arr = [list(map(int, input().split())) for _ in range(9)]
r, c, m, p = [0]*9,[0]*9,[0]*9,[]
for i in range(9):
    for j in range(9):
        if arr[i][j] != 0:
            r[i] |= (1 << arr[i][j])
            c[j] |= (1 << arr[i][j])
            m[3*(i//3) + (j//3)] |= (1 << arr[i][j])
        else: p.append((i, j))
def sol(k):
    if k == len(p):
        for i in arr:
            for j in i: print(j, end=' ')
            print()
        exit(0)
    x, y = p[k]
    for i in range(1, 10):
        t = (x//3)*3+y//3
        if r[x] & (1 << i) == 0 and c[y] & (1 << i) == 0 and m[t] & (1 << i) == 0:
            a, b, n = r[x], c[y], m[(x//3)*3 + y//3]
            r[x], c[y], m[t] = r[x] | (1 << i), c[y] | (1 << i), m[t] | (1 << i)
            arr[x][y] = i
            sol(k+1)
            arr[x][y] = 0
            r[x], c[y], m[t] = a, b, n
sol(0)

