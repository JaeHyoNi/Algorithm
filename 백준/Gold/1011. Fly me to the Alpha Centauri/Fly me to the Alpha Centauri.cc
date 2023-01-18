#include <bits/stdc++.h>
using namespace std;

int main(){
    int X,Y,T; cin>>T;
    while(T--){
        cin>>X>>Y; Y=Y-X;;
        double dpow = sqrt(Y);
		int pow = round(sqrt(Y)); 
		if(dpow<=pow) cout<<pow*2-1<<"\n"; 
		else cout<<pow*2<<"\n"; 
    }
}