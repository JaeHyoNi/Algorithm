def solution(n, lighthouse):
    arr = [0 for _ in range(n+1)]
    road = [set() for _ in range(n+1)]
    for i, j in lighthouse:
        road[i].add(j)
        road[j].add(i)
        arr[i] += 1
        arr[j] += 1
    answer = 0
    wait = []
    for i in range(1, n+1):
        if arr[i] == 1:
            wait.append(i)
    while wait:
        i = wait.pop()
        if arr[i] == 1:
            light = tuple(road[i])[0]
            answer += 1
            for k in road[light]:
                arr[k] -= 1
                road[k].remove(light)
                if arr[k] == 1:
                    wait.append(k)
            arr[light] = 0
    return answer