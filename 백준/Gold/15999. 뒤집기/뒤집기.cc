#include <bits/stdc++.h>
using namespace std;
bool arr[2000][2000] = {false,};

int main(){
    int x[4] = {-1,0,1,0} , y[4] = {0,1,0,-1};
    int N,M,num=0,a,b,answer=1;    cin>>N>>M; 
    bool plus;
    string str;
    for(int i=0; i<N; i++){ cin>>str;
        for(int j=0; j<M; j++){
            arr[i][j] = (str[j] == 'W') ? true : false;
        }
    }
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            plus = true;
            for(int k=0; k<4; k++){
                a = i+x[k] , b = j+y[k];
                if(a>=0 && b>=0 && a<N && b<M){
                    if(arr[a][b] != arr[i][j]){
                        plus = false; break;
                    }    
                }
            }
            if(plus) num++;
        }
    }
    for(int i=0;i<num;i++){
        answer *= 2;
        answer %= 1000000007;
    }
    cout<<answer;
}