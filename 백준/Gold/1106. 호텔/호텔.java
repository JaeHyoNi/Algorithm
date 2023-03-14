import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[100001];
		int t=0, C=sc.nextInt(), N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int v=sc.nextInt(), c=sc.nextInt();
			for(int k=0; k<100001; k++) { 
				dp[k+v]= Math.max(dp[k]+c, dp[k+v]); 
				if(dp[k+v] >= C) break;
			}
		}
		while(dp[t]< C) t+=1;
		System.out.println(t);
	}
}

