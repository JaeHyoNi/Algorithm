#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;


int main() {
	string str;
	getline(cin, str);
	string::iterator iter = str.begin();
	int num=0,temp=0;
	while (iter != str.end()) {
		if (*iter == '(') {
			if (*(iter + 1) == ')') {
				num += temp;
				iter = iter + 2;
				continue;
			}
			temp++;
			num++;
		}
		else 
			temp--;
		iter++;
	}
	cout << num;
}