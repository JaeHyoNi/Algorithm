#include <bits/stdc++.h>
using namespace std;

int main(){
    int a,b,N;
    scanf("%d",&N);
    for(int i=1;i<=N;i++){
        scanf("%d %d",&a,&b);
        printf("Case #%d: %d\n",i,a+b);
    }
    return 0;
}