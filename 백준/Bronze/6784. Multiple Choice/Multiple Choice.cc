#include <bits/stdc++.h>
using namespace std;

int main(){
    int N,ANS=0; cin>>N;
    vector<char> s1(N),s2(N);
    for(int i=0;i<N;i++){cin>>s1[i];}
    for(int i=0;i<N;i++){cin>>s2[i];}
    for(int i=0;i<N;i++){if(s1[i]==s2[i]) ANS++;}
    cout<<ANS;
}