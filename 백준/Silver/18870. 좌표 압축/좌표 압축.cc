#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    cin >>N;
    vector<int> v(N); 
    for (int i = 0; i < N; i++){cin >> v[i];}
    vector<int> cv(v); 
    sort(cv.begin(), cv.end());
    cv.erase(unique(cv.begin(), cv.end()), cv.end());
    for (int i = 0; i < N; i++){
        auto it = lower_bound(cv.begin(), cv.end(), v[i]);
        cout << it - cv.begin() << ' ';
    }
    return 0;
}