#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int siz = 1;
int arr[1000001];
int where(int &num){
    int start=0, end = siz , tmp=0;
    while(start < end){
        tmp = (end - start) / 2 + start;
        if(arr[tmp] == num) return tmp;
        else if(arr[tmp] > num) end = tmp;
        else start = tmp+1;   
    }
    if(start == end) tmp = start;
    return tmp;
}

int main(void){
    int N,tmp,it;
    cin>>N;
    cin>>tmp;
    arr[0] = tmp;
    for(int i=0; i<N-1;i++){
        cin>>tmp;
        it = where(tmp);
        arr[it] = tmp;
        if( it == siz ) {
            siz = siz + 1;
        }
    }
    cout<<siz;
    return 0;
}