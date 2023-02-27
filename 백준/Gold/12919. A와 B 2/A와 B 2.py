import sys
str1, str2 =list(input()), list(input())
def dfs(t): 
    if t==str1:
        print(1)
        sys.exit()
    if len(t)==0:
        return 0
    if t[-1]=='A': 
        dfs(t[:-1]) 
    if t[0]=='B': 
        dfs(t[1:][::-1]) 
dfs(str2)
print(0)