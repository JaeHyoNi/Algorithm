#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin>>n; n %= 8;
    cout<< (n > 5 || !n ? (10 - n) % 8 : n);
}