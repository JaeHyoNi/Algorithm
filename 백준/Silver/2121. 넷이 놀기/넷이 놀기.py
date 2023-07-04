N, (A, B) = int(input()), map(int, input().split())
exist, arr, ans = set(), [tuple(map(int, input().split())) for _ in range(N)], 0
exist.update(arr)
for x, y in arr:
    if (x+A, y+B) in exist and (x+A, y) in exist and (x, y+B) in exist:
        ans += 1
print(ans)