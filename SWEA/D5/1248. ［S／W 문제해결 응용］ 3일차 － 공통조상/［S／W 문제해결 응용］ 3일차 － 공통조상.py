T = int(input())
for test_case in range(1, T+1):
    V, E, t1, t2 = list(map(int, input().split()))
    arr = list(map(int, input().split()))
    mother, son = [0 for _ in range(V+1)], [[] for _ in range(V+1)]
    for (i, j) in [(arr[i], arr[i+1]) for i in range(0, int(len(arr)), 2)]:
        mother[j] = i
        son[i].append(j)
    root, temp, answer = set(), t1, 1
    while t1 != 0:
        root.add(t1)
        t1 = mother[t1]
    while t2 not in root:
        t2 = mother[t2]
    arr = [t2]
    while arr:
        temp = arr.pop()
        for i in son[temp]:
            arr.append(i)
            answer += 1
    print('#{} {} {}'.format(test_case, t2, answer))