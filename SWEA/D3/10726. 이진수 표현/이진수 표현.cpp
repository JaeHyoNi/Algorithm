#include <bits/stdc++.h>
using namespace std;
int main(void){
    int T; cin>>T;
    for(int i=0; i<T; i++){
        int N, M; cin>>N>>M;
        if( (((1<<N)-1) & M) == ((1<<N)-1)) cout<<"#"<<i+1<<" ON"<<endl;
        else cout<<"#"<<i+1<<" OFF"<<endl;
    }
}