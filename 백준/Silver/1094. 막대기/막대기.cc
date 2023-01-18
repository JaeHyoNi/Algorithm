#include <bits/stdc++.h>
using namespace std;
 
int main() {
    int N;   cin>>N;
    int count=1, min=64, sum=64;
    while(sum>N) {
        min=min/2;
        if(sum-min>=N) {sum-=min;} 
        else {count++;}
    }
    cout<<count;
    return 0;
}