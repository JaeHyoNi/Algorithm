#include <bits/stdc++.h>
using namespace std;
int main(){
	int N; cin >> N;
    vector<int> div(N);
	for (int i = 0; i < N; i++){cin >> div[i];}
	sort(div.begin(),div.end());
	cout << div[0]*div[N - 1];
}