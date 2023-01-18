#include <bits/stdc++.h>
using namespace std;

bool check(int num){
    int mod;
    while(num){
        mod = num % 10;
        if (!(mod == 4 || mod == 7)) return false; 
        num /= 10;
    }
    return true;
}
int main(void){
    int N; cin >> N;
    for (int i=N;i>=1;i--){if (check(i)){cout << i;  break;}}
}