#include <bits/stdc++.h>
using namespace std;
int main(){
    int N; cin>>N;
    if(N>=90){cout<<"A"; return 0;}
    if(N>=80){cout<<"B"; return 0;}
    if(N>=70){cout<<"C"; return 0;}
    if(N>=60){cout<<"D"; return 0;}
    else {cout<<"F"; return 0;}
}