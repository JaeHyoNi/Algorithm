for _ in range(int(input())):
    N=int(input())
    def D(l,k):
        if k==N+1:
            if eval(l.replace(" ",""))==0:print(l)
            return
        for t in [" ","+","-"]:D(l+t+str(k),k+1)
    D("1",2)
    print()
