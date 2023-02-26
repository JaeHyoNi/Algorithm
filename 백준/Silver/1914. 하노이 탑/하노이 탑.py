N = int(input())
ans = []
def hanoi(n, f, b, t):
    if n == 1:
        ans.append((f, t))
    else:
        hanoi(n - 1, f, t, b)
        ans.append((f, t))
        hanoi(n - 1, b, f, t)
if N <= 20:
    hanoi(N, 1, 2, 3)
    print(len(ans))
else:
    print(2**N-1)

if N <= 20:
    for f, t in ans:
        print(f, t)
