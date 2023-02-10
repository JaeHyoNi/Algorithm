import sys
T = int(input())
arr = []
friendnum = []
def find_parent(x):
    if arr[x] == x: return x
    arr[x] = find_parent(arr[x])
    return arr[x]

def union(x, y):
    a, b = find_parent(x), find_parent(y)
    if a == b: return
    if a > b:
        friendnum[b] += friendnum[a]
        arr[a] = b
    else:
        friendnum[a] += friendnum[b]
        arr[b] = a

input = sys.stdin.readline
for _ in range(T):
    N = int(input())
    friend = {}
    flag = 0
    arr = [i for i in range(2*N+1)]
    friendnum = [1 for _ in range(2*N+1)]
    for _ in range(N):
        f1, f2 = input().split()
        if f1 not in friend:
            friend[f1] = flag
            flag += 1
        if f2 not in friend:
            friend[f2] = flag
            flag += 1
        union(friend[f1], friend[f2])
        print(friendnum[find_parent(friend[f1])])