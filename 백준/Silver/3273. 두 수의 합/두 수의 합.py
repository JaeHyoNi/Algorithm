N, arr, T, ans, exist = input(), sorted(list(map(int, input().split()))), int(input()), 0, set()
exist.update(arr)
for i in arr:
    if i * 2 >= T: break
    if T-i in exist: ans += 1
print(ans)
