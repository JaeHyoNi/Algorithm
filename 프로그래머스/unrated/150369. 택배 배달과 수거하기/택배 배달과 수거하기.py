def solution(cap, n, deliveries, pickups):
    answer, N = 0, 0
    deliveries.append(0)
    pickups.append(0)
    for i in range(n-1, -1, -1):
        deliveries[i] += deliveries[i+1]
        pickups[i] += pickups[i+1]
        while deliveries[i] > N or pickups[i] > N:
            answer += (i+1)
            N += cap
    return answer*2