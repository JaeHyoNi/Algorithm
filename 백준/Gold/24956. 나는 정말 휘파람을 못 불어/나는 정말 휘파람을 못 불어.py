N, S = int(input()), input()
W, H, E, ans = 0, 0 , 0, 0
for s in S:
    if s == 'W':W += 1
    elif s == 'H':H += W
    elif s == 'E':
        ans = (2 * ans + E ) % 1000000007
        E += H
print(ans)