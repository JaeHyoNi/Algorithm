#include <bits/stdc++.h>
using namespace std;
int arr[9][9], r[9], c[9], m[9], siz;
vector<pair<int,int>> p;
void sol(int k){
    if(k == siz){for(int i=0;i<9;i++){for(int j=0;j<9;j++){cout<<arr[i][j]<<" ";}cout<<"\n";}exit(0);}
    int x = p[k].first, y=p[k].second;
    for(int i=1; i<10; i++){
        int t = (x/3)*3+y/3;
        if((r[x] & (1 << i)) == 0 && (c[y] & (1 << i)) == 0 && (m[t] & (1 << i)) == 0) {
            int a = r[x], b = c[y], n = m[(x / 3) * 3 + y / 3];
            r[x] |= (1 << i); c[y] |= (1 << i); m[t] |= (1 << i);
            arr[x][y] = i;
            sol(k + 1);
            arr[x][y] = 0;
            r[x] = a; c[y] = b; m[t] = n;
        }
    }
}
int main(){
    for(int i=0; i<9; i++) for(int j=0; j<9; j++) {
        scanf("%d",&arr[i][j]);
        if(arr[i][j] != 0){
            r[i] |= (1 << arr[i][j]);
            c[j] |= (1 << arr[i][j]);
            m[3*(i/3) + (j/3)] |= (1 << arr[i][j]);
        }
        else {p.push_back({i,j}); siz++;}
    }
    sol(0);
}