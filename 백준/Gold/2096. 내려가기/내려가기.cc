#include <bits/stdc++.h>
using namespace std;

int main(){         
    int arr[3],num[3],temp[3],MAX[3],MIN[3],N; scanf("%d",&N);
    scanf("%d %d %d",&num[0],&num[1],&num[2]);
    MAX[0] = num[0] , MAX[1] = num[1] ,MAX[2] = num[2];
    MIN[0] = num[0] , MIN[1] = num[1] ,MIN[2] = num[2];
    
    for(int i=1;i<N;i++){
        scanf("%d %d %d",&arr[0],&arr[1],&arr[2]);
        temp[0] = arr[0] + max(MAX[0],MAX[1]);
        temp[1] = arr[1] + max(MAX[0],max(MAX[1],MAX[2]));
        temp[2] = arr[2] + max(MAX[1],MAX[2]);
        MAX[0]=temp[0],MAX[1]=temp[1],MAX[2]=temp[2];
        
        temp[0] = arr[0] + min(MIN[0],MIN[1]);
        temp[1] = arr[1] + min(MIN[0],min(MIN[1],MIN[2]));
        temp[2] = arr[2] + min(MIN[1],MIN[2]);
        MIN[0]=temp[0],MIN[1]=temp[1],MIN[2]=temp[2];
    }
    cout<<max(MAX[0],max(MAX[1],MAX[2]))<<" "<<min(MIN[0],min(MIN[1],MIN[2]));
    return 0;
}
