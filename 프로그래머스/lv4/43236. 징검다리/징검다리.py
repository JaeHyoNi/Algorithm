def solution(distance, rocks, n):
    answer = 0
    s = 0
    e = 1e13
    rocks.sort()
    while s <= e : 
        pre = 0
        num = 0
        mid = (s+e)//2
        for rock in rocks : 
            if rock - pre >= mid : 
                pre = rock
                continue
            else : 
                num += 1
                if num > n:
                    break
        if distance - pre < mid :
            num += 1
            
        if num <= n :
            answer = mid
            s = mid + 1
        else : 
            e = mid - 1
    return answer