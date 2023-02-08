import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[T+1][2];
		for(int i=1; i<=T; i++) {
			arr[i][0] = sc.nextInt(); arr[i][1] = sc.nextInt();
		}
		int[] dp = new int[T+1];
		for(int i=1; i<=T; i++) {
			dp[i] = Math.max(dp[i-1], dp[i]); 
			if(i+arr[i][0]-1 > T) continue;
			dp[i+arr[i][0]-1] = Math.max(dp[i+arr[i][0]-1],dp[i-1] + arr[i][1]);
		}
		System.out.println(dp[T]);
	}
}
