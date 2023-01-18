#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> arr;
int x[4] = {-1,0,1,0} , y[4] = {0,1,0,-1};
int x_siz , y_siz;

pair<bool,int> B(int dep,pair<int,int> loc_A,pair<int,int> loc_B);
inline bool valid(int a,int b){return (a>=0 && b>=0 && a<x_siz && b<y_siz);}

//true:승리 false:패배
//승리할때는 가장 짧은걸 리턴해야 하고 
//패배할떄는 가장 긴걸 리턴해야 한다.
pair<bool,int> A(int dep,pair<int,int> loc_A,pair<int,int> loc_B){
    bool win = false;
    //다른곳으로 가기 전에 현재 있는곳을 없앤다
    //이후 사람의 발판이 없어지는거까지 체크하기 위함

    //내가 밞았던곳이 떨어졌을 떄
    if(arr[loc_A.first][loc_A.second] == 0){return {false,dep};}
    else{arr[loc_A.first][loc_A.second] = 0;}

    pair<bool,int> result;
    int ax,ay,MAX = dep,MIN = INT32_MAX;
    for(int i=0;i<4;i++){
        ax = loc_A.first + x[i] , ay = loc_A.second + y[i];
        if(valid(ax,ay) && arr[ax][ay] == 1){
            result = B(dep+1,{ax,ay},loc_B);
            //A승리
            if(result.first == false){
                win = true;
                MIN = min(MIN,result.second);
            }
            //B승리
            else{MAX = max(MAX,result.second);}
        }
    }
    arr[loc_A.first][loc_A.second] = 1;
    if(win){return {true,MIN};}
    else{return {false,MAX};}
}

pair<bool,int> B(int dep,pair<int,int> loc_A,pair<int,int> loc_B){
    bool win = false;
    if(arr[loc_B.first][loc_B.second] == 0){return {false,dep};}
    else{arr[loc_B.first][loc_B.second] = 0;}
    pair<bool,int> result;
    int bx,by,MAX = dep,MIN = INT32_MAX;
    for(int i=0;i<4;i++){
        bx = loc_B.first + x[i] , by = loc_B.second + y[i];
        if(valid(bx,by) && arr[bx][by] == 1){
            result = A(dep+1,loc_A,{bx,by});
            if(result.first == false){
                win = true;
                MIN = min(MIN,result.second);
            }
            else{MAX = max(MAX,result.second);}
        }
    }

    arr[loc_B.first][loc_B.second] = 1;
    if(win){return {true,MIN};}
    else{return {false,MAX};}
}

int solution(vector<vector<int>> board, vector<int> aloc, vector<int> bloc){
    arr = board;
    x_siz = arr.size();
    y_siz = arr[0].size();
    pair<bool,int> result = A(0,{aloc[0],aloc[1]},{bloc[0],bloc[1]});
    return result.second;
}