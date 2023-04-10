import sys
input = sys.stdin.readline
N = int(input())
arr = list(input().split())
m, k = map(int, input().split())
josu = [list(map(int, input().split())) for _ in range(m)]
for tmp in josu:
    flag = True
    for i in tmp:
        if arr[i-1] == 'P':
            flag = False
            break
    if flag:
        print("W")
        exit(0)
print("P")