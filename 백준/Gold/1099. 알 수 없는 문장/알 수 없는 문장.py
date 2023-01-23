from collections import defaultdict
sen = input()
N = int(input())
dp = [[float('inf') for _ in range(len(sen)+1)] for _ in range(len(sen) + 1)]
for wordnum in range(N):
    word = input()
    siz = len(word)
    if siz > len(sen): continue
    sent, t = defaultdict(int), defaultdict(int)
    for i in range(siz):
        sent[sen[i]] += 1
        t[word[i]] += 1
    for i in range(0, len(sen) - siz + 1):
        if sent == t:
            num = 0
            for k in range(siz):
                if sen[i + k] != word[k]:
                    num += 1
            dp[i][i+len(word)] = min(dp[i][i+len(word)], num)
        if siz+i < len(sen):
            sent[sen[i]] -= 1
            sent[sen[siz + i]] += 1
            if sent[sen[i]] == 0: del sent[sen[i]]
for e in range(len(sen)+1):
    for s in range(e):
        for mid in range(s, e):
            if dp[s][mid] != float('inf') and dp[mid][e] != float('inf') and dp[s][e] > dp[s][mid] + dp[mid][e]:
                dp[s][e] = dp[s][mid] + dp[mid][e]

if dp[0][-1] != float('inf'): print(dp[0][-1])
else: print(-1)