import java.util.Scanner;

public class Main {
	static int[] row;
	static int N, ans;
	static boolean flag;
	public static void dfs(int dep) {
		if(dep == N) {
			ans += 1;
			return;
		}
		for(int k=0; k<N; k++) {
			row[dep]= k;
			flag = true;
			for(int i=0; i<dep; i++) {
				if(row[i]==row[dep] || Math.abs(row[i]-row[dep]) == Math.abs(i-dep)) {
					flag = false;
					break;
				}
			} 
			if(flag) dfs(dep+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		row = new int[N];
		dfs(0);
		System.out.println(ans);
	}
}
