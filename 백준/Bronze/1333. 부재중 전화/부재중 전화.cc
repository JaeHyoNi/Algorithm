#include <bits/stdc++.h>
using namespace std;


int main() {
	vector<int> arr;
	int N,L,D; cin>>N>>L>>D;
	int now = 0; 
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < L; j++) { arr.push_back(1);}
		for (int j = 0; j < 5; j++) { arr.push_back(0);}
	}
	
	while (1) {
		if (now > arr.size()) {break;}
		if (arr[now] == 0) {break; }
		else {now = now + D;}
	}
	cout << now;
}