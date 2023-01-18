#include <bits/stdc++.h>
using namespace std;
using ld = long double;
struct game{string t1;string t2;ld w;ld d;ld l;};
game games[6];
vector<int> score(4,0),temp(4,0);
long double win_rate[4];
map<string, int> team;
void DFS(int num,long double nowper){
    if(nowper == 0){return;}
    if(num == 6){
        temp = score;
        int num1=0,num2=0;
        sort(temp.begin(),temp.end(),greater<>());
        int MAX1 = temp[0], MAX2 = temp[1];
        for(int i=0;i<4;i++){
            if(score[i] == MAX1) num1++;
            else if(score[i] == MAX2) num2++;
        }
        if(MAX1 == MAX2){for(int i=0;i<4;i++){if(score[i] == MAX1){win_rate[i] += nowper/num1*2;}}}
        else{
            for(int i=0;i<4;i++){
                if(score[i] == MAX1){win_rate[i] += nowper;}
                else if(score[i] == MAX2){win_rate[i] += (nowper/num2);}
            }
        }
        return;
    }
    score[team[games[num].t1]] += 3;
    DFS(num+1 ,nowper*games[num].w);
    score[team[games[num].t1]] -= 3;
    
    score[team[games[num].t1]] += 1 , score[team[games[num].t2]] += 1;
    DFS(num+1 ,nowper*games[num].d);
    score[team[games[num].t1]] -= 1 , score[team[games[num].t2]] -= 1;
    
    score[team[games[num].t2]] += 3;
    DFS(num+1 ,nowper*games[num].l);
    score[team[games[num].t2]] -= 3;
}

int main(){
    long double W,D,L;
    string str,t1,t2;
    for(int i=0;i<4;i++){cin>>str; team[str] = i;}
    for(int i=0;i<6;i++){
        cin>>t1>>t2>>W>>D>>L;
        games[i] = {t1,t2,W,D,L};
    }
    DFS(0,1);
    for(int i=0;i<4;i++){
        cout<<win_rate[i]<<endl;
    }
}
