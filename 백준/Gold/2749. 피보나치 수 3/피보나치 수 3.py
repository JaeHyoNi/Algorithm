fibo = [0, 1]
for i in range(2,1500000):
    fibo.append(fibo[i-1]+fibo[i-2])
    fibo[i] %= 1000000
print(fibo[int(input())%1500000])