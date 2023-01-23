from bisect import bisect_right, bisect_left
N, M, K = map(int, input().split())
minsu =sorted(list(map(int, input().split())))
chulsu = list(map(int, input().split()))
root = [i for i in range(len(minsu)+1)]

def find(v):
    if v == root[v]:
        return v
    root[v] = find(root[v])
    return root[v]

for card in chulsu:
    next_card = bisect_right(minsu, card)
    index = find(next_card)
    print(minsu[index])
    r1 = find(index)
    r2 = find(index+1)
    root[r1] = r2