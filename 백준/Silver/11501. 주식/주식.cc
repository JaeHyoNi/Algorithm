#include <bits/stdc++.h>

using namespace std;

void solution(vector<long long> &prices){
    auto iter = prices.end();
    iter = iter - 1;
    int max_price = *iter;
    long long sum = 0;
    stack<string> ans;
    do{
        iter = iter - 1;
        if((*iter) < max_price){
            sum = sum + max_price - *iter;
        }
        else if(*iter > max_price){
            max_price = *iter;
        }
    }while(iter != prices.begin());
    cout<<sum<<endl;
}




int main(void){
    int N,M,tmp;
    cin>>N;
    vector<long long> prices,temp;
    for(int i=0;i<N;i++){
        cin>>M;
        for(long long j=0;j<M;j++){
            cin>>tmp;
            prices.push_back(tmp);  
        }
        solution(prices);
        prices = temp;
    }
}