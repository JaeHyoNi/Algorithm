#include <bits/stdc++.h>
using namespace std;

int MAX = 0,N;

int find_max(vector<vector<int>> &arr){
    int num = 0;
    for(auto K: arr){
        for(auto J: K){
            num = (num < J) ? J:num;
        }
    }
    return num;
}

vector<vector<int>> slide_left(vector<vector<int>> &arr){
    vector<vector<int>> result;
    result.resize(N,vector<int>(N,0));
    for(int H=0; H<N; H++){
        int flag = -1,k = 0;
        for(int i=0;i<N;i++){
            if(arr[H][i] != 0){
                if(flag == -1){flag = arr[H][i];}
                else{
                    if( flag == arr[H][i]){result[H][k++] = flag*2;    flag = -1;}
                    else{result[H][k++] = flag;  flag = arr[H][i];}
                }
            }
        }
        if(flag != -1){result[H][k++] = flag;}
        while(k<N){result[H][k++] = 0;}
    }
    return result;
}

vector<vector<int>> slide_right(vector<vector<int>> &arr){
    vector<vector<int>> result;
    result.resize(N,vector<int>(N,0));
    for(int H=0;H<N;H++){
        int flag = -1, k = N-1 ;
        for(int i=N-1; i>=0; i--){
            if(arr[H][i] != 0){
                if(flag == -1){flag = arr[H][i];}
                else{
                    if(flag == arr[H][i]){
                        result[H][k--] = flag*2;
                        flag = -1;
                    }
                    else{
                        result[H][k--] = flag;
                        flag = arr[H][i];
                    }
                }
            }
        }
        if(flag != -1){result[H][k--] = flag;}
        while(k>=0){result[H][k--] = 0;}
    }
    return result;
}

vector<vector<int>> slide_down(vector<vector<int>> &arr){
    vector<vector<int>> result;
    result.resize(N,vector<int>(N,0));
    for(int H=0;H<N;H++){
        int flag = -1, k = N-1 ;
        for(int i=N-1; i>=0; i--){
            if(arr[i][H] != 0){
                if(flag == -1){flag = arr[i][H];}
                else{
                    if(flag == arr[i][H]){
                        result[k--][H]  = flag*2;
                        flag = -1;
                    }
                    else{
                        result[k--][H] = flag;
                        flag = arr[i][H];
                    }
                }
            }
        }
        if(flag != -1){result[k--][H] = flag;}
        while(k>=0){result[k--][H] = 0;}
    }
    return result;
}


vector<vector<int>> slide_up(vector<vector<int>> &arr){
    vector<vector<int>> result;
    result.resize(N,vector<int>(N,0));
    for(int H=0; H<N; H++){
        int flag = -1,k = 0;
        for(int i=0;i<N;i++){
            if(arr[i][H] != 0){
                if(flag == -1){flag = arr[i][H];}
                else{
                    if( flag == arr[i][H]){result[k++][H] = flag*2;    flag = -1;}
                    else{result[k++][H] = flag;  flag = arr[i][H];}
                }
            }
        }
        if(flag != -1){result[k++][H] = flag;}
        while(k<N){result[k++][H] = 0;}
    }
    return result;
}


void next_step(vector<vector<int>> arr,int dep){
    if(dep == 5){
        MAX =  max(find_max(arr),MAX);
        return;
    }
    vector<vector<int>> temp;
    temp = slide_right(arr);
    next_step(temp,dep+1);
    temp = slide_left(arr);
    next_step(temp,dep+1);
    temp = slide_up(arr);
    next_step(temp,dep+1);
    temp = slide_down(arr);
    next_step(temp,dep+1);
}


int main(){
    cin>>N;
    vector<vector<int>> arr;
    arr.resize(N,vector<int>(N));
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin>>arr[i][j];
        }
    }
    next_step(arr,0);
    cout<<MAX<<"\n";
}