GG = int(input())
P = int(input())
gi = [int(input()) for _ in range(P)]
arr = [i for i in range(GG+1)]
answer = 0


def find_mother(N):
    if arr[N] == N:
        return N
    else:
        arr[N] = find_mother(arr[N])
        return arr[N]


for num in gi:
    temp = find_mother(num)
    if temp == 0:
        break
    else:
        arr[temp] = arr[temp-1]
        answer += 1

print(answer)
