#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;



int main(void){
    int N,tmp;
    cin>>N;
    bool is;
    vector<int> arr;
    vector<int> arr3(N,0);
    for(int i=0;i<N;i++){
        cin>>tmp;
        is = true;
        arr.push_back(tmp);
        for(int j=0;j<i;j++){
            if(arr[j] < arr[i]){
                arr3[i] = max(arr3[i] , arr3[j] + tmp);
                is = false;
            }
        }
        if(is){
            arr3[i] = tmp;
        }
    }
    cout<<*max_element(arr3.begin(),arr3.end());
}