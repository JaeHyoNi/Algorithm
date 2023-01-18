#include <bits/stdc++.h>
using namespace std;
int arr[1000001];
int main(){
    queue<int> next_num;
    int siz,N,k,ans_num=0;scanf("%d",&N);
    next_num.push(N);
    if(N==1){printf("0\n1");return 0;}
    while(arr[1]==0){
        siz = next_num.size();
        while(siz--){
            k = next_num.front();
            if(k%3==0 && arr[k/3]==0) {
                arr[k/3] = 3;
                next_num.push(k/3);
            }
            if(k%2==0 && arr[k/2]==0) {
                arr[k/2] = 2;
                next_num.push(k/2);
            }
            if(arr[k-1] == 0){
                arr[k-1] = 1;
                next_num.push(k-1);
            }
            next_num.pop();
        }
        ans_num++;
    }
    stack<int> ans;
    k=1;
    while(k!=N){
        ans.push(k);
        if(arr[k]==1) k++;
        else if(arr[k]==2) k = k*2;
        else if(arr[k]==3) k = k*3;
    }
    ans.push(N);
    printf("%d\n",ans_num);
    while(!ans.empty()){
        printf("%d ",ans.top());
        ans.pop();
    }
    return 0;
}