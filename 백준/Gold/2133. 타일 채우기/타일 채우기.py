N = int(input())
arr = [0] * (31)
arr[2] = 3
for i in range(3, N+1):
    if i%2 != 0:
        continue
    arr[i] += (arr[i-2] * 3)
    tmp = 4
    while i - tmp > 0:
        arr[i] += (arr[i-tmp] * 2)
        tmp += 2
    arr[i] += 2
print(arr[N])