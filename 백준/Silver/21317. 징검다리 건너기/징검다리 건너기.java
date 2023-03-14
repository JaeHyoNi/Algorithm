import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N-1; i++) {arr[i][0] = sc.nextInt(); arr[i][1] = sc.nextInt();}
		int K = sc.nextInt();
		int dp1[] = new int[N], dp2[] = new int[N];
		for(int i=0; i<N; i++) dp1[i]= dp2[i]= 9999999;  
		dp1[0] = 0; dp2[0] = 0;
		for(int i=0; i<N-1; i++) {
			dp1[i+1] = Math.min(dp1[i]+ arr[i][0], dp1[i+1]);
			dp2[i+1] = Math.min(dp2[i]+ arr[i][0], dp2[i+1]);
			if(i+2 < N) {
				dp1[i+2] = Math.min(arr[i][1] + dp1[i], dp1[i+2]);
				dp2[i+2] = Math.min(arr[i][1] + dp2[i], dp2[i+2]);
			}
			if(i+3 < N) dp2[i+3] = Math.min(dp1[i]+K, dp2[i+3]); 
		}
		System.out.print(Math.min(dp1[N-1], dp2[N-1]));
	}
}