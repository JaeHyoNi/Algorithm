#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int N,num,x,y;
vector<pair<int, int>> p1;
vector<pair<int, int>> p2;
int visit[1001][1001];

int solution(int A, int B){
    if(A==num || B==num)    return 0;
    int& vis = visit[A][B];
    if(vis != -1) return vis;
    vis = 1;
    int maxLocation = max(A,B) + 1 ;
    int disA = abs(p1[maxLocation].first  - p1[A].first) + 
               abs(p1[maxLocation].second - p1[A].second);
    int disB = abs(p2[maxLocation].first  - p2[B].first) + 
               abs(p2[maxLocation].second - p2[B].second);
    int r1 = solution(maxLocation,B) + disA;
    int r2 = solution(A,maxLocation) + disB;
    return vis = min(r1,r2);
}
void reconstruct(int A, int B){
    if (A == num || B == num)   return;
    int maxLocation = max(A, B) + 1;
    int distA = abs(p1[maxLocation].first  - p1[A].first) +
                abs(p1[maxLocation].second - p1[A].second);
    int distB = abs(p2[maxLocation].first  - p2[B].first) +
                abs(p2[maxLocation].second - p2[B].second);
    int ret1 = solution(maxLocation, B) + distA;
    int ret2 = solution(A, maxLocation) + distB;
    if (ret1 > ret2){cout << 2 << endl;
        reconstruct(A, maxLocation);
    }
    else{
        cout << 1 << endl;
        reconstruct(maxLocation, B);
    }
}

int main(void){
    cin>>N>>num;
    p1.push_back({1,1});
    p2.push_back({N,N});
    for(int i=0;i<num;i++){
        cin>>x>>y;
        p1.push_back({x,y});
        p2.push_back({x,y});
    }
    memset(visit, -1, sizeof(visit));    
    cout<< solution(0,0)<<endl;
    reconstruct(0,0);
    return 0;
}