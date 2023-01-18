#include <bits/stdc++.h>
using namespace std;
int arr[1001];
int main(){
	int sum = 0;
	pair<int, int> res;
	for (int i=0;i<10;i++){
		int num=0;    cin >> num;
		sum += num;
		arr[num]++;
		if (res.first < arr[num]){
			res.first = arr[num];
			res.second = num;
		}
	}
	cout << sum / 10 << "\n" << res.second;
}