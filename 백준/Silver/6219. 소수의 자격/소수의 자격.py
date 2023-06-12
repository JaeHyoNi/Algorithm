A, B, D = map(int, input().split())
D, ans = str(D), 0
arr = [True] * (B+1)
for i in range(2, B+1):
    if not arr[i]: continue
    m = i * 2
    while m < B+1:
        arr[m] = False
        m += i
for i in range(A, B+1):
    if arr[i] and D in str(i):
        ans += 1
print(ans)