#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    int x,y,w,h;
    int t1,t2;
    cin >> x >> y >> w >> h;
    t1 = min(x,y);
    t2 = min(w-x,h-y);
    cout << min(t1,t2);
}