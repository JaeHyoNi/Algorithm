#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;


//소문자 대문자 숫자 공백
int main() {
	string str;
	int arr[4] = { 0, };
	while (getline(cin, str)) {
		auto iter = str.begin();
		for (char x : str) {
			if (x > 96 && x < 123) arr[0]++;
			else if (x > 64 && x < 91)	arr[1]++;
			else if (x > 47 && x < 58)	arr[2]++;
			else if (x == ' ')	arr[3]++;
		}
		for (int x : arr)
			cout << x << " ";
		cout << "\n";
		for (int i = 0; i < 4; i++) {
			arr[i] = 0;
		}
	}
	return 0;
}