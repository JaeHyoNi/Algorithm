#include <iostream>
#include <queue>
#include <vector>
using namespace std;
vector<int> arr(50,-2);

struct node { int value; int parent; queue<int> sons; };

int main() {
	int N, t, answer = 0; cin >> N;
	vector<node> arr(N, { 0 });
	for (int i = 0; i < N; i++) {
		cin >> t;
		if (t == -1) {
			arr[i].parent = i; continue;
		}
		else arr[i].parent = t;
		arr[t].value += 1;
		arr[t].sons.push(i);
	}
	cin >> t;
	queue<int> wait; wait.push(t);
	if (arr[t].parent != t) { arr[arr[t].parent].value -= 1; }
	while (!wait.empty()) {
		t = wait.front(); wait.pop();  arr[t].value = -2;
		while (!arr[t].sons.empty()) {
			wait.push(arr[t].sons.front()); arr[t].sons.pop();
		}
	}
	for(int i = 0; i < N; i++) { if (arr[i].value == 0) answer += 1; }
	cout << answer;
}