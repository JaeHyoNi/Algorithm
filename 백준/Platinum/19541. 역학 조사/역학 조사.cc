#include<iostream>
#include<vector>

using namespace std;

int main() {
	int n, m;
	cin >> n >> m;

	vector<vector<int>> A(m);

	for (int i = 0; i < m; i++) {
		int aisize;
		cin >> aisize;
		A[i].resize(aisize);

		for (auto &Aij : A[i]) {
			cin >> Aij;
			Aij -= 1;
		}
		
	}

	vector<int> last(n);
	for (int i = 0; i < n; i++) {
		cin >> last[i];
	}

	vector<int> track = last;
	for (int i = m - 1; i >= 0; i--) {
		int on = 1;
		for (auto Aij : A[i]) {
			if (track[Aij] == 0) on = 0;
		}
		if (on == 1) continue;
		for (auto Aij : A[i]) {
			track[Aij] = 0;
		}

	}

	vector<int> sim = track;
	for (int i = 0; i < m; i++) {
		int on = 0;
		for (auto Aij : A[i]) {
			if (sim[Aij] == 1) on = 1;
		}
		if (on == 0) continue;
		for (auto Aij : A[i]) {
			sim[Aij] = 1;
		}
	}
	if (sim != last) {
		cout << "NO\n";
		return 0;
	}
	cout << "YES\n";
	for (auto Ai : track) cout << Ai << ' ';
	cout << '\n';

}
