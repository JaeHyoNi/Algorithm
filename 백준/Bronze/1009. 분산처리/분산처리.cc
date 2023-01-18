#include <bits/stdc++.h>
using namespace std;
int main() {
	int t,a,b,ans;
	cin >> t;
	while(t--) {
		ans = 1;
		cin >> a >> b;
		b=!(b%4) ? 4:b%4;
		while (b--)ans *= a;
		cout << (ans%10 ? ans%10 :10) << "\n";
	}
}