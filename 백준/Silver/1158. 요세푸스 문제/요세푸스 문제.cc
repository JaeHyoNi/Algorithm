#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;


int main() {
	int num, i, j, term;
	scanf("%d", &num);
	scanf("%d", &term);
	queue<int> table;
	for (i = 1; i < num+1; i++) {
		table.push(i);
	}
	i = 1;
	cout << '<';
	while (!table.empty()) {
		if (i % term == 0) {
			if (table.size() == 1) 
				printf("%d>", table.front());
			else 
				printf("%d, ", table.front());
			table.pop();
		}
		else {
			table.push(table.front());
			table.pop();
		}
		i++;
	}
}