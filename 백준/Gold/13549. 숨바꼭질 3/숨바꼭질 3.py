from collections import deque
s, target = map(int, input().split())
arr = [float('inf') for _ in range(100001)]
arr[s] = 0
wait = deque([s])
while wait:
    n = wait.popleft()
    if n == target: continue
    val = arr[n]
    if val >= arr[target]: continue
    if n-1 >= 0 and arr[n-1] > val + 1:
        arr[n-1] = val+1
        wait.append(n-1)
    if n+1 <= 100000 and arr[n+1] > val + 1:
        arr[n+1] = val + 1
        wait.append(n+1)
    while n <= 100000 and n!=0:
        if val < arr[n]:
            arr[n] = val
            wait.append(n)
        n *= 2
print(arr[target])