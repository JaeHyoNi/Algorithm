def solution(cap, n, deliveries, pickups):
    answer = 0
    i, di, pi = n-1, n-1, n-1
    while i >= 0:
        if deliveries[i] != 0 or pickups[i] != 0:
            answer += (i * 2 + 2)
            tmp = cap
            while di >= 0 and tmp > 0:
                if deliveries[di] > tmp:
                    deliveries[di] -= tmp
                    tmp = 0
                else:
                    tmp -= deliveries[di]
                    deliveries[di] = 0
                    di -= 1
            tmp = cap
            while pi >= 0 and tmp > 0:
                if pickups[pi] > tmp:
                    pickups[pi] -= tmp
                    tmp = 0
                else:
                    tmp -= pickups[pi]
                    pickups[pi] = 0
                    pi -= 1
            i = max(pi, di)
        else:
            i -= 1
    return answer
