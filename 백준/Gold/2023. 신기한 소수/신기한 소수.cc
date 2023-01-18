#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
 
void input(int & n) {cin >> n;}
 
bool isPrime(int num){
    if(num<2) return false;
    for(int i=2; i*i<=num; i++){
        if(num%i == 0) return false;
    }
    return true;
}
 
void recursive(int first, int n){
    if(n==0) printf("%d\n", first);
    
    for(int i=1; i<10; i+=2){ 
        int tmp = first*10 + i;
        if(isPrime(tmp)){
            recursive(tmp, n-1);
        }
    }
 
}
int main(void){
    int n;
    input(n);
    int prime[4] = {2, 3, 5, 7};
    for(int i=0; i<4; i++){
        recursive(prime[i], n-1);
    }
    return 0;
}