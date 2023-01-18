#include <iostream>
#include <vector>
using namespace std;
vector<long long> d(1000001);
int main()
{
    int t; scanf("%d", &t);
    vector<long long> f(1000001, 1);
    for (int i = 2; i <= 1000000; i++) {for (int j = 1; i * j <= 1000000; j++) {f[i * j] += i;}}
    for (int i = 1; i <= 1000000; i++) {d[i] = d[i - 1] + f[i];}
    while (t--) {
        int n; scanf("%d", &n);
        printf("%lld\n", d[n]);
    }
    return 0;
}