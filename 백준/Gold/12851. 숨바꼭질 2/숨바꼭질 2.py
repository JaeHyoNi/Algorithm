from collections import deque
s, target = map(int, input().split())
N = 100000
visittime = [-1 for _ in range(N+1)]
howmany = [0 for _ in range(N+1)]
wait = deque([(s, 0)])
visittime[s] = 0
howmany[s] = 1
while wait:
    w, t = wait.popleft()
    for i in [w*2, w-1, w+1]:
        if 0 <= i <= N:
            if visittime[i] == -1:
                visittime[i] = t+1
                howmany[i] = howmany[w]
                if i != target:
                    wait.append((i, t+1))
            elif visittime[i] == t+1:
                howmany[i] += howmany[w]
print(visittime[target])
print(howmany[target])
