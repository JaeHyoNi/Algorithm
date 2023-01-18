#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int arr1[30][30];
int arr2[30][30];
int check[30][30];
int N, M;
void change(int x, int y,int flag,int to) {
	if (arr1[x][y] == flag) {
		//printf("arr1[%d][%d]의 %d를 %d로 바꿈\n", x, y, flag, to);
		arr1[x][y] = to;
	}
	else {
		return;
	}
	if (x - 1 > -1) change(x - 1, y, flag, to);
	if (y + 1 < M) change(x, y + 1, flag, to);
	if (x + 1 < N) change(x + 1, y, flag, to);
	if (y - 1 > -1) change(x, y - 1, flag, to);
	return;
}

int main() {
	cin >> N >> M;
	/*
	int** arr1 = new int* [N];
	int** arr2 = new int* [N];
	int** visit = new int* [N];
	for (int i = 0; i < N; i++) {
		arr1[i] = new int[M];
		arr2[i] = new int[M];
		visit[i] = new int[M];
		memset(arr1[i], 0, sizeof(int) * M);
		memset(arr2[i], 0, sizeof(int) * M);
		memset(visit[i], 0, sizeof(int) * M);
	}
	*/
	for (int i = 0; i < N; i++) {for (int j = 0; j < M; j++) {cin >> arr1[i][j];}}
	for (int i = 0; i < N; i++) {for (int j = 0; j < M; j++) {cin >> arr2[i][j];}
	}/*
	for (int i = 0; i < N; i++) {for (int j = 0; j < M; j++) {cout << arr1[i][j];}cout << endl;}
	for (int i = 0; i < N; i++) {for (int j = 0; j < M; j++) {cout << arr2[i][j];}cout << endl;}
	*/
	int limit = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (arr1[i][j] != arr2[i][j]) {
				limit++;
				if (limit > 1) { cout << "NO"; break; }
				change(i, j, arr1[i][j], arr2[i][j]);
			}
		}
		if (limit > 1) break;
	}
	if (limit < 2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr1[i][j] != arr2[i][j]) {
					limit++;
					if (limit > 1) { cout << "NO"; break; }
					change(i, j, arr1[i][j], arr2[i][j]);
				}
			}
			if (limit > 1) break;
		}
	}
	if (limit < 2) {
		cout << "YES";
	}
	/*
	cout << endl;
	for (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) { cout << arr1[i][j]; }cout << endl; }
	cout << endl;
	for (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) { cout << arr2[i][j]; }cout << endl; }
	*/

}

