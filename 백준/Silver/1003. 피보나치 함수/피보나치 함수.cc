#include <bits/stdc++.h>
using namespace std;

int main(){
    int arr0[41] = {1,0,1};
    int arr1[41] = {0,1,1};
    for(int i=3;i<=40;i++){
        arr0[i] = arr0[i-1]+arr0[i-2];
        arr1[i] = arr1[i-1]+arr1[i-2];
    }
    int N,T; cin>>T;
    while(T--){
        cin>>N;
        cout<<arr0[N]<<" "<<arr1[N]<<"\n";
    }
    return 0;
}