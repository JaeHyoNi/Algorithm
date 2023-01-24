N = int(input())
arr = [[0, False] for _ in range(10)]
for i in range(N):
    num = input()
    arr[ord(num[0])-ord('A')][1] = True
    num = reversed(num)
    for k, c in enumerate(num):
        arr[ord(c)-ord('A')][0] += 10**k
num = 9
answer = 0
arr = sorted(arr, reverse=True)
if arr[-1][1]:
    for i in range(8, -1, -1):
        if not arr[i][1]:
            del arr[i]
            break
for i in arr:
    answer += (num*i[0])
    num -= 1
print(answer)