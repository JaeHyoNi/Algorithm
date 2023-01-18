#include <bits/stdc++.h>
using namespace std;
int arr[1001][1001];
int main(){
    string s1,s2;
    cin>>s1>>s2;
    int siz1 = s1.size(), siz2 = s2.size();
    for(int i=1;i<=siz1;i++){
        for(int j=1;j<=siz2;j++){
            if(s1[i-1] == s2[j-1]){
                arr[i][j] = arr[i-1][j-1] + 1;
            }
            else{
                arr[i][j] = max(arr[i-1][j] , arr[i][j-1]);
            }
        }
    }
    cout<<arr[siz1][siz2];
}
