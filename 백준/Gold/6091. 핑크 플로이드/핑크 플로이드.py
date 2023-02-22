from heapq import heappush, heappop
N = int(input())
arr = [[0] * N for _ in range(N)]
wait = []
for i in range(N-1):
    li = list(map(int, input().split()))
    siz = 0
    for j in range(i+1, N):
        heappush(wait, (li[siz], (i, j)))
        siz += 1
ans = [[0] * N for _ in range(N)]
Enum = 0
mother = [i for i in range(N+1)]

def find_mother(k):
    if mother[k] == k: return k
    mother[k] = find_mother(mother[k])
    return mother[k]

def union(a, b):
    aa, bb = find_mother(a), find_mother(b)
    if aa < bb : mother[bb] = aa
    else : mother[aa] = bb


while Enum < N-1:
    k, (f, t) = heappop(wait)
    if find_mother(f) == find_mother(t): continue
    ans[f][t] = ans[t][f] = k
    union(f, t)
    Enum += 1

for i in ans:
    print(N - i.count(0), end=' ')
    for k, v in enumerate(i):
        if v != 0:
            print(k+1, end = ' ')
    print()