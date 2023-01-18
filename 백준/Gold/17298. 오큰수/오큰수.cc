#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int main() {
	int num, i, j;
	stack<pair<int,int>> temp;
	cin >> num;
	int* arr = new int[num];
	int* sol = new int[num];
	for (int i = 0; i < num; i++) {sol[i] = -1;}
	for (i = 0; i < num; i++) {cin >> arr[i];}
	i = 0;
	while (i < num) {
		if (temp.empty()) { temp.push(make_pair(arr[i],i)); i++; }
		else if (temp.top().first > arr[i]) {
			temp.push(make_pair(arr[i],i));
			i++;
		}
		else {
			while (!temp.empty()&& temp.top().first < arr[i] ) {
				sol[temp.top().second] = arr[i];
				temp.pop();
			}
			temp.push(make_pair(arr[i],i));
			i++;
		}
	}
	for (int i = 0; i < num; i++) {
		cout << sol[i] << " ";
	}
}