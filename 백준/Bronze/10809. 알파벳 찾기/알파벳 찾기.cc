#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int main() {
	int alphabet[26] = {};
	for (int i = 0; i < 26; i++) {alphabet[i] = -1;}
	string str;
	cin >> str;
	auto iter = str.begin();
	int i = 0;
	while (iter != str.end()) {
		if (alphabet[int((*iter) - 'a')] == -1) {
			alphabet[int((*iter) - 'a')] = i;
		}
		i++;
		iter++;
	}
	for (int x : alphabet) {
		cout << x << " ";
	}
}