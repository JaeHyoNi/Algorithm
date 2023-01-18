#include <bits/stdc++.h>
using namespace std;
int main(){
    long long X,N; cin>>X>>N;
    long long SUM = 0,a,b;
    while(N--){
        cin>>a>>b;
        SUM+=(a*b);
    }
    if(X==SUM){cout<<"Yes";}
    else{cout<<"No";}
}