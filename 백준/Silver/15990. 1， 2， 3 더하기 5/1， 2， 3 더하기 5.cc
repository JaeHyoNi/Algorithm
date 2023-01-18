#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

long long d[3][100005];
int main() {
	int temp,num,max=4;
	cin >> num;
	d[0][1] = 1; d[0][3] = 1;d[1][2] = 1; d[1][3] = 1;d[2][3] = 1;
	for (int i = 0; i < num; i++) {
		cin >> temp;
		if (max > temp) { cout << (d[0][temp] + d[1][temp] + d[2][temp])%1000000009 << "\n"; continue; }
		else {
			for (int j = max; j < temp + 1; j++) {
				d[0][j] = (d[1][j - 1] + d[2][j - 1])%1000000009;
				d[1][j] = (d[0][j - 2] + d[2][j - 2])%1000000009;
				d[2][j] = (d[0][j - 3] + d[1][j - 3])%1000000009;
			}
			max = temp;
			cout << (d[0][temp] + d[1][temp] + d[2][temp])%1000000009 << "\n";
		}
	}
}