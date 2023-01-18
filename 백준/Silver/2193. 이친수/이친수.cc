#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

long long arr[2][105];

int main() {
	arr[0][1] = arr[1][1] = 1;
	int num;
	cin >> num;
	for (int i = 2; i < num + 1; i++) {
		arr[0][i] = arr[0][i - 1] + arr[1][i - 1];
		arr[1][i] = arr[0][i - 1];
	}
	cout << arr[1][num];
}
