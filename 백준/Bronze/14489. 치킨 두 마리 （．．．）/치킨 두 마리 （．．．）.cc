#include <bits/stdc++.h>
using namespace std;

int main(){
    long long A,B,price;
    cin>>A>>B>>price;
    if(A+B >= 2*price) cout<<A-2*price+B;
    else cout<<A+B;
}