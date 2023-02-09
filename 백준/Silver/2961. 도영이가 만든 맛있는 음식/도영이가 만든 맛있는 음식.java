import java.util.Scanner;
public class Main {
	static int[] sin, map;
	static int N,ans=Integer.MAX_VALUE;
	public static void dfs(int dep, int s, int m) {
		if(dep == N) {
			if(m==0) return;
			else ans = Math.min(Math.abs(s-m), ans);
			return;
		}
		dfs(dep+1, s, m);
		dfs(dep+1, s*sin[dep], m+map[dep]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sin = new int[N]; map = new int[N];
		for(int i=0; i<N;i++) {sin[i]= sc.nextInt(); map[i]= sc.nextInt();}
		dfs(0, 1, 0);
		System.out.println(ans);
	}
}
