#include <bits/stdc++.h>
using namespace std;

int main(void){
    int n; cin>>n;
    int temp, j;
    for(int i=0; i<n; i++){
        cin>>temp; j=1;
        int visited = 0;
        while(visited != 1023){
            int k = temp * j++;
            while(k>0){
                visited |= (1 << k%10);
                k = k / 10;
            }
        }
        cout<<"#"<<i+1<<" "<<temp*(j-1)<<endl;
    }
}