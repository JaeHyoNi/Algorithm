#include <iostream>
using namespace std;
int main(){
  int x, y,ans; cin>>x>>y;
  ans = (x>0) ? ((y>0)? 1 : 4) : ((y>0) ? 2 : 3);    
  cout<<ans;
}