import sys
input = sys.stdin.readline
N = int(input())
L, A = [[0] * N for _ in range(4)], 0
for i in range(N): L[0][i], L[1][i], L[2][i], L[3][i] = map(int, input().split())
c1 = dict()
for i in L[0]:
    for j in L[1]:
        if i+j in c1: c1[i+j]+=1
        else: c1[i+j] = 1
for i in L[2]:
    for j in L[3]:
        if -(i+j) in c1: A+=c1[-(i+j)]
print(A)