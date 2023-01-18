#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;


int main() {
	int a,t;
	double  d, k;
	cin >> a >> d >> k;
	t = a;
	double temp = d;
	double sum = 0;
	double lose = 100;
	double plus = 0;
	while (temp < 100) {
		plus = t * lose * temp / 100 / 100;
		//printf("t = %d     temp = %f    lose = %f   plus = %f   sum = %f\n", t, temp, lose, plus, sum);
		sum += plus;
		lose = lose / 100 * (100 - temp);
		temp += temp * k / 100;
		t += a;
	}
	//printf("a = %d     temp = %f    lose = %f   plus = %f   sum = %f\n", t, temp, lose, t * lose / 100, sum);
	sum += t * lose / 100;
	printf("%.7f", sum);
	return 0;
}

