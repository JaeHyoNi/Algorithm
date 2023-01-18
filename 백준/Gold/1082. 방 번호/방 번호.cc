#include <bits/stdc++.h>
using namespace std;
vector<int> price;
int N,money,MIN=9999999,MIN_n,temp;
string answer = "";

void uping(string &str){
    for(auto &K:str){
        for(int i=N-1;i>temp;i--){
            if(money >= price[i]){
                K = i+'0'; money-=price[i];break;
            }
        }
    }
}
int main(){ cin>>N; price.resize(N);
    for(int i=0;i<N;i++){cin>>price[i]; if(price[i] <= MIN){ MIN_n = i , MIN = price[i];}}
    cin>>money;
    for(int i=0;i<N;i++){price[i]-=MIN;}
    for(int i=0;i<money/MIN;i++){answer.push_back(MIN_n+'0');}
    money %= MIN;
    temp = MIN_n;
    if(answer[0] == '0'){temp = 0;}
    uping(answer);
    if(answer[0] == '0'){
        bool change = false;
        while(!change){
            if(answer.empty()) break;
            for(int i=N-1;i>0;i--){
                if(money>=price[i]){
                    answer[0] = i+'0';
                    change = true;
                    break;
                }
            }
            if(!change){answer.pop_back(); money+=MIN;}
        }
    }
    uping(answer);
    if(answer.empty()) cout<<0;
    else{cout<<answer;}
    return 0;
}