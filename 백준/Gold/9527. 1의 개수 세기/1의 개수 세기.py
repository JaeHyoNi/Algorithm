def go(N):
    ans, tmp = 0, 1
    while tmp <= N:
        ans += (N // tmp // 2 * tmp)
        if N // tmp % 2 != 0:
            ans += (N % tmp + 1)
        tmp = tmp << 1
    return ans
A, B = map(int, input().split())
print(go(B) - go(A - 1))