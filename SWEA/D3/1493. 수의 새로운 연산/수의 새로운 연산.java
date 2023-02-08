import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++) {
			int N=sc.nextInt(), M = sc.nextInt();
			int n=N, m=M;
			int i=0, j=1;
			while(n>j) {n-=j;	j += 1;}
			int x1 = n, y1 = j-n+1;
			i=0; j=1;
			while(m>j) {m-=j; j+=1;}
			int x2 = m, y2 = j-m+1;
			int x3 = x1+x2, y3 = y1+y2;
			int temp = 0;
			for(i=x3; i<x1+x2+y1+y2-1; i++) {temp += i;}
			System.out.printf("#%d %d\n",tc, (int)(((x3+1)*x3)/2) + temp);
		}
	}
}
