from collections import defaultdict, deque
T = int(input())
for test_case in range(1, T+1):
    N, M = map(int, input().split())
    arr = defaultdict(list)
    for _ in range(M):
        s, e = map(int, input().split())
        arr[s].append(e)
        arr[e].append(s)
    answer = 0
    
    
    def dfs(now, dep):
        global answer
        answer = max(answer, dep)
        for i in arr[now]:
            if i not in visit:
                visit.add(i)
                dfs(i, dep+1)
                visit.remove(i)

    for i in range(1, N+1):
        visit = set([i])
        dfs(i, 1)
    print("#{} {}".format(test_case, answer))




