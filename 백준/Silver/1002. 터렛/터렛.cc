#include <bits/stdc++.h>
using namespace std;

int main(){
    int N; cin>>N;
    for(int i=0;i<N;i++){
        int x1,x2,y1,y2,r1,r2; cin>>x1>>y1>>r1>>x2>>y2>>r2;
        double d = sqrt(pow(x1-x2,2)+pow(y1-y2,2));
        double sub = abs(r1-r2);
        if(d == 0 && r1 == r2) cout<<"-1\n";
        else if(sub == d || r1 + r2 == d) cout<<"1\n";
        else if(sub < d && d < (r1+r2))cout<<"2\n";
        else cout<<"0\n";
    }
    return 0;
}