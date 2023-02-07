#include<bits/stdc++.h>
using namespace std;
int main(int argc, char** argv){
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case){
        int N; cin>>N;
        int temp, m=1000000, count = 0;
        for(int i=0; i<N; i++){
            cin>> temp;
            temp = abs(temp);
            if(temp == m) {count += 1;}
            else if(temp < m) {m = temp; count = 1;}
        }
        printf("#%d %d %d\n", test_case, m, count);
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}