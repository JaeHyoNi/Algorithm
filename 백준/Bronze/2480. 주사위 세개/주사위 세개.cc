#include <bits/stdc++.h>
using namespace std;

int main() {
	int A, B, C; cin >> A >> B >> C;
	if (A == B && B == C) { cout << 10000 + A * 1000; }
	else if (A != B && B != C && A != C) { cout << max(A, max(B, C)) * 100; }
	else {
		if (A == B || A == C) { cout << 1000 + A * 100; }
		else { cout << 1000 + C * 100; }
	}
}