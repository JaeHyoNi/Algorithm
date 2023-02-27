str1, str2 = list(input()), list(input())
siz1, siz2 = len(str1), len(str2)
while True:
    if siz1 == siz2 and str1 == str2:
        print(1)
        exit(0)
    elif siz1 >= siz2:
        print(0)
        exit(0)
    elif str2[-1] == 'A':
        str2.pop()
        siz2-=1
    else:
        str2.pop()
        str2 = str2[::-1]
        siz2 -=1
