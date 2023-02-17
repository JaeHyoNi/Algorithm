import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static Integer[] arr = {0,0,0,0,0,0};
	static int answer = 0, max;
	static int l,M;
	static void swap(int n, int m) {
		arr[n]^=arr[m];   
		arr[m]^=arr[n];   
		arr[n]^=arr[m];
	}
	static void find(int M) {
		if(answer == max) return;
		if(M == 0) {
			int i = 0;
			for(int t=l-1; t>=0; t--) {i = i * 10 + arr[t]; }
			if(i>answer) answer = i;
			return;
		}
		for(int i=0; i<l-1; i++) {
			for(int j=i+1; j<l; j++) {
				if(i==j) continue;
				swap(i, j);
				find(M-1);
				if(answer == max) return;
				swap(i, j);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), N;
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); M = sc.nextInt();
			l = 0; answer = 0;
			for(int i=0; i<6; i++) {
				if(N == 0) break;
				arr[i]= N % 10;
				N /= 10;
				l++;
			}
			Integer[] temp = new Integer[l];
			for(int i=0; i<l;i++) temp[i]= arr[i]; 
			Arrays.sort(temp);
			max = 0;
			for(int t=l-1; t>=0; t--) {max = max * 10 + temp[t];}
			if(M > 6) {
				if(M%2 == 0) {
					answer = (max/100) * 100;
					int a = max % 10 * 10;
					int b = max % 100 / 10;
					answer = answer + b + a;
				}
				else {answer = max;}
			}
			else{find(M);}
			System.out.printf("#%d %d\n",tc, answer);
		}
	}
}
