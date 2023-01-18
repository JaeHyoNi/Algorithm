#include <bits/stdc++.h>
using namespace std;
int arr[1002][1002];

int solution(vector<vector<int>> board, vector<vector<int>> skill) {
    int answer = 0;
    int a,b,c,d,board_x = board.size() , board_y = board[0].size();
    for(auto &K:skill){
        if(K[0] == 1) {K[5] *= -1;}
        a=K[1],b=K[2],c=K[3],d=K[4];
        arr[a][b] += K[5];
        arr[c+1][d+1] += K[5];
        arr[c+1][b] -= K[5];
        arr[a][d+1] -= K[5];
    }
    for(int i=0; i<board_x; i++){
        for(int j=0; j<board_y; j++){
            arr[i][j+1] += arr[i][j];
        }
    }
    for(int i=0; i<board_x; i++){
        for(int j=0; j<board_y; j++){
            arr[i+1][j] += arr[i][j];
            board[i][j] += arr[i][j];
            if(board[i][j] >= 1) answer++;
        }
    }
    return answer;
}