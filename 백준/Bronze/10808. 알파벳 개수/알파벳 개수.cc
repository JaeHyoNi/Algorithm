#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;
int alphabet[26];
int main() {
	string str;
	cin >> str;
	auto iter = str.begin();
	while (iter != str.end()) {
		alphabet[int((*iter) - 'a')]++;
		iter++;
	}
	for (int x : alphabet) {
		cout << x << " ";
	}
}