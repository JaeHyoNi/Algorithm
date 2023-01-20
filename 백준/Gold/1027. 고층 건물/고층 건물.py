T = int(input())
arr = list(map(int, input().split()))
see = [[False for _ in range(T)] for _ in range(T)]

def ccw(x1,y1, x2,y2, x3,y3):
    return (x2-x1)*(y3-y1)-(x3-x1)*(y2-y1)

for i in range(T-1):
    for j in range(i+1, T):
        itis = True
        for k in range(i+1, j):
            if ccw(i, arr[i], j, arr[j], k, arr[k]) >= 0:
                itis = False
                break
        if itis:
            see[i][j] = see[j][i] = True

answer = 0
for i in see:
    answer = max(answer, i.count(True))
print(answer)