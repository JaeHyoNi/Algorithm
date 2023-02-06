import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(), M = sc.nextInt();
			int[] arr = new int[N];
			int[] arr2 = new int[M];
			for(int i=0; i<N; i++) {arr[i] = sc.nextInt();}
			for(int i=0; i<M; i++) {arr2[i]=sc.nextInt();}
			int max = 0;
			if(N>M) {int[] temp = arr2; arr2 = arr; arr = temp;N = N^M^(M=N);}
			for(int i=0; i<=M-N; i++) {
				int temp=0;
				for(int j=0; j<N; j++) {
					temp += (arr[j] * arr2[i + j]);
				}
				max = max < temp ? temp : max;
			}
			System.out.printf("#%d %d\n",tc,max);
		}
	}
}
