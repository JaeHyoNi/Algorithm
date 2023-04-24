from itertools import combinations
N, M = map(int, input().split())
for i in sorted(list(combinations(sorted(list(map(int, input().split()))), M))):
    flag = True
    for j in range(len(i)-1):
        if i[j] > i[j+1]:
            flag = False
            break
    if flag:
        for j in i: print(j, end=' ')
        print()