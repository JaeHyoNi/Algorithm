#include <bits/stdc++.h>
using namespace std;
int main(void){
    int T; cin>>T;
    for(int i=0; i<T; i++){
        int N, M; scanf("%d %d",&N,&M);
        if( (((1<<N)-1) & M) == ((1<<N)-1)) printf("#%d ON\n",i+1);
        else printf("#%d OFF\n",i+1);
    }
}