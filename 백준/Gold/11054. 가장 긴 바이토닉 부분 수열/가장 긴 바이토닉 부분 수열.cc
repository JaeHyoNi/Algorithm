#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[1001];

int cache[1001];
int cache2[1001];

int main(void){
    fill_n(cache,1001,1);
    fill_n(cache2,1001,1);
    int N,tmp;
    cin>>N;
    for(int i=0;i<N;i++) cin>>arr[i];
    for(int i=0;i<N;i++){
        for(int j=0;j<i;j++){
            if(arr[i] > arr[j]){
                cache[i] = max(cache[i] , cache[j]+1);
            }
        }
    }
    for(int i=N-1;i>=0;i--){
        for(int j=N-1;j>=i;j--){
            if(arr[i] > arr[j]){
                cache2[i] = max(cache2[j] + 1 , cache2[i]);
            }
        }
    }
    int ans=0;
    for(int i=0;i<N;i++){
        if(cache[i] + cache2[i] - 1 > ans){
            ans = cache[i] + cache2[i] - 1;
        }
    }
    cout<<ans;
}