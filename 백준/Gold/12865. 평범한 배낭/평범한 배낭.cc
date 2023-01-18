#include <bits/stdc++.h>
using namespace std;

int arr[101][100001];

int main() {
    int n, k; cin >> n >> k;
    vector<pair<int, int>> bag;
    bag.resize(n+1);
    for (int i = 1; i <= n; i++) {cin >> bag[i].first >> bag[i].second;}
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= k; j++) {
            if (bag[i].first > j) {
                arr[i][j] = arr[i - 1][j];
            }
            else {
                arr[i][j] = max(arr[i - 1][j], arr[i - 1][j - bag[i].first] + bag[i].second);
            }
        }
    } 
    cout << arr[n ][k];
}