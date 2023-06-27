from collections import deque
N = int(input())
arr = sorted([tuple(map(int, input().split())) for _ in range(N)])
wait = deque([(min(t[0] for t in arr), min(t[1] for t in arr), max(t[0] for t in arr), max(t[1] for t in arr))])
visit, A = set(), 1e10
while wait:
    lx, ly, rx, ry = wait.popleft()
    if (lx, ly, rx, ry) in visit: continue
    visit.add((lx, ly, rx, ry))
    maxx, maxy, minx, miny, tmp = lx, ly, rx, ry, 0
    for x, y in arr:
        if lx <= x <= rx and ly <= y <= ry: tmp += 1
        if lx < x < rx: minx, maxx = min(minx, x), max(maxx, x)
        if ly < y < ry: miny, maxy = min(miny, y), max(maxy, y)
    if tmp >= N//2:
        if (rx - lx + 2) * (ry - ly + 2) < A:
            A = (rx - lx + 2) * (ry - ly + 2)
        wait.append((minx, ly, rx, ry))
        wait.append((lx, miny, rx, ry))
        wait.append((lx, ly, maxx, ry))
        wait.append((lx, ly, rx, maxy))
print(A)