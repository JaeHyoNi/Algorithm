#include <bits/stdc++.h>
using namespace std;
queue<pair<string, int> > q;
int VISIT[1000001][11];
int main() {
    string str,change;
    int K, ans = 0,siz;
    cin >> str >> K;
    siz = str.size();
    q.push({ str, 0 });
    pair<string, int> now;
    while (!q.empty()) {
        now = q.front(); q.pop();
        if (now.second == K) {ans = max(ans, stoi(now.first));continue;}
        change = now.first;
        for (int i = 0; i < siz - 1; i++) {
            for (int j = i + 1; j < siz; j++) {
                swap(change[i], change[j]);
                if (change[0] == '0' || VISIT[stoi(change)][now.second + 1]) {
                    swap(change[i], change[j]);   continue;
                }
                q.push(make_pair(change, now.second + 1));
                VISIT[stoi(change)][now.second + 1] = 1;
                swap(change[i], change[j]);
            }
        }
    }
    if (ans == 0) cout << "-1";
    else cout << ans;
}