#include <bits/stdc++.h>
using namespace std;
typedef struct {int s;int e;int val;}contest;
int main(){
    int N,temp,iter=0,MAX = 0;
    scanf("%d",&N);
    vector<contest> con(N);
    for(int i=0;i<N;i++){scanf("%d %d %d",&con[i].s,&con[i].e,&con[i].val);}
    sort(con.begin(),con.end(),[](const contest &a,const contest &b){return a.s ^ b.s ? a.s < b.s : a.e < b.e;});
    vector<int> Dyn(N,0);
    Dyn[N-1] = con[N-1].val;
    for(int i=N-2;i>=0;i--){
        Dyn[i] = max(con[i].val , Dyn[i+1]);
        auto iter = upper_bound(con.begin(),con.end(),contest{con[i].e,-1,-1},[](const contest &a,const contest &b){return a.s<b.s;});
        if(iter != con.end()){
            Dyn[i] = max( Dyn[i] , Dyn[iter-con.begin()] + con[i].val);
        }
    }
    cout<<Dyn[0];
}