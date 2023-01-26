N = int(input())
arr = list(map(int, input().split()))
foward = [arr[0]]
backward = [arr[-1]]

def gcd(a, b):
    if a<=b :
        a, b = b, a
    while(1):
        if a%b==0: return b
        a, b = b, a%b

s, e = arr[0], arr[-1]
for i in range(N-1):
    s, e = gcd(s, arr[i+1]), gcd(e, arr[N-2-i])
    foward.append(s)
    backward.append(e)
num = foward[-1]
backward = backward[::-1]
find = False
if backward[1] > num and arr[0] % backward[1] != 0:
    print(backward[1], arr[0])
    find = True
elif foward[-2] > num and arr[-1] % foward[-2] != 0:
    print(foward[-2], arr[-1])
    find = True
for i in range(1, N-1):
    temp = gcd(foward[i-1], backward[i+1])
    if temp > num and arr[i] % temp != 0:
        print(temp, arr[i])
        find = True
if not find:
    print(-1)
