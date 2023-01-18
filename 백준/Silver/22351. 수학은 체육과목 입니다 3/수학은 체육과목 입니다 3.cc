#include <bits/stdc++.h>
using namespace std;

int main(){
    int T,flag = 1,ans;
    string str,temp; cin>>str;
    while(1){
        temp = str.substr(0,flag++);
        T = stoi(temp);
        ans = T;
        temp = "";
        while(str.size()>temp.size()){
            temp+=to_string(T++);
        }
        if(temp == str){break;}
        else{continue;}
    }
    cout<<ans<<" "<<T-1;
}