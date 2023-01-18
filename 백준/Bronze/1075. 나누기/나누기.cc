#include <iostream>
using namespace std;

int main(){
  int N,D;
  cin >>N>>D;
  int ans = N / 100 * 100 % D;
  if(ans != 0) ans = D - ans;
  if(ans < 10) cout << '0' << ans << endl;
  else cout << ans << endl;
}