#include <bits/stdc++.h>
using namespace std;


map<int, int> tree;
long long ans=1;
int main() {
    int n,tmp;
    scanf("%d", &n);
    scanf("%d",&tmp);tree[tmp] = 1;
    for(int i=1;i<n;i++){
        scanf("%d",&tmp);
        auto K = tree.lower_bound(tmp);
        if(K==tree.begin()) {
            tree[tmp] = K->second + 1;
            ans += tree[tmp];
        }
        else if(K==tree.end()){
            K--;
            tree[tmp] = K->second + 1;
            ans+= tree[tmp];
        }
        else{
            auto J = K;
            J--;
            tree[tmp] = max(K->second+1 , J->second+1);
            ans+= tree[tmp];
        }
    }
    cout<<ans<<endl;
    return 0;
}