#include <bits/stdc++.h>
using namespace std;

vector<pair<int,int>> cubes;
int answer = 0 , siz;
int val[20];

void solution(int l,int w,int h,int now){
    if(l==0 || w==0 || h==0) return;
    int S = min(l,min(w,h));
    bool is = false;
    for(int i=now;i<siz;i++){
        if(val[cubes[i].first] <= S && cubes[i].second > 0){
            is = true;
            now = i;
            
            break;
        }
    }
    if(!is){
        cout<<"-1\n"; 
        exit(0);
    }
    int N = val[cubes[now].first];
    cubes[now].second--;
    answer++;
    solution(l-N,N,N,now);
    solution(l,w-N,N,now);
    solution(l,w,h-N,now);
}

int main(){
    for(int i=0;i<20;i++){val[i] = pow(2,i);}
    int L,W,H,N,t1,t2; cin>>L>>W>>H; 
    cin>> N; siz = N;
    for(int i=0;i<N;i++){cin>>t1>>t2;  cubes.push_back({t1,t2}); }
    reverse(cubes.begin(),cubes.end());
    solution(L,W,H,0);   cout<<answer<<"\n";
}