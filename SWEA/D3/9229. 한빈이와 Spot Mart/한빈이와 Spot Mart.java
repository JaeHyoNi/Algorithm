import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans, s, e, N, M, T = sc.nextInt();
		Integer [] arr;
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); M = sc.nextInt();
			arr = new Integer[N];
            ans = 0; s=0; e=N-1;
			for(int i=0; i<N; i++) { arr[i] = sc.nextInt();}
            Arrays.sort(arr);
			while(s < e) { 
				if(arr[s]+arr[e] == M) {ans = M; break;}
				if(arr[s]+arr[e] < M) {ans = Math.max(ans, arr[s]+arr[e]); s += 1;}
				else {e -= 1;}
			}
			if(ans == 0) ans = -1;
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
