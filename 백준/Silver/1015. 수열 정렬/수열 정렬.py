from collections import defaultdict
N = int(input())
arr = list(map(int, input().split()))
P = [i for i in range(N)]
target = sorted(arr)
where = defaultdict(list)
for i in range(N): where[target[i]].append(i)
visited = [False for _ in range(N)]
answer = []
for i in arr:
    temp = 0
    while visited[where[i][temp]]: temp += 1
    answer.append(where[i][temp])
    visited[where[i][temp]] = True
for i in answer:
    print(i, end=' ')