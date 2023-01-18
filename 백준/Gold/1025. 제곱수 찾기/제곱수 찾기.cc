#include <bits/stdc++.h>
using namespace std;

int main(){
  int N,M,arr[9][9],temp,temp2,a,b,a2,b2,answer = -1;
  string str;
  cin >> N >> M;
  for(int i=0;i<N;i++){
    cin >> str;
    for(int j=0;j<M;j++){arr[i][j] = (int)(str[j]-'0');}
  }
  //x좌표와 y좌표 전무 훝음
  for(int x=0;x<N;x++){
    for(int y=0;y<M;y++){
      //x와 y에 offset을 줘가며 숫자를 이어붙임
      for(int off_x = -N; off_x < N; off_x++){
        for(int off_y = -M; off_y < M; off_y++){
          if(off_x == 0 && off_y == 0){continue;}
          a = x , b = y , temp =0;
          while(a < N && a >= 0 && b < M && b >= 0){
            temp = temp*10 + arr[a][b];
            a += off_x , b += off_y;
            if((sqrt(temp) - (int)(sqrt(temp)) == 0)){
              answer = max(temp , answer);
            }
          }
        }
      }
    }
  }
  cout<<answer;
}