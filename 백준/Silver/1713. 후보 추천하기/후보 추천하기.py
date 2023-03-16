N = int(input())
M = int(input())
arr = list(map(int, input().split()))
frame = dict()
siz = 0
for i, n in enumerate(arr):
    if n in frame:
        frame[n][0] += 1
    elif siz < N:
        frame[n] = [1, i]
        siz += 1
    else:
        tk, tv, to = 999, 99999, 99999
        for k, v in frame.items():
            if v[0] < tv or (v[0] == tv and v[1] < to):
                tk, tv, to = k, v[0], v[1]
        del(frame[tk])
        frame[n] = [1, i]
for i in sorted(frame):
    print(i, end=' ')