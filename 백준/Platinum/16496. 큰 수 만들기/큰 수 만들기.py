from functools import cmp_to_key
def comp(a, b): return int(b+a) - int(a+b)
input()
print(int(''.join(sorted(list(input().split()), key=cmp_to_key(comp)))))