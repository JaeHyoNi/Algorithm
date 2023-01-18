def Solution(S,T) : 
    sum = 1
    for i in S : 
        if i not in T : 
            return -1
    index = 0
    siz = len(T)
    for i in range(len(S)) : 
        while S[i] != T[index] : 
            index += 1
            if index >= siz : 
                sum += 1
                index = 0
        index += 1
        if index >= siz : 
            sum += 1
            index = 0
    if index == 0 : 
        sum -= 1
    return sum
S = input()
T = input()
print(Solution(S,T))