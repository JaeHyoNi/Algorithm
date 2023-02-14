import java.util.Scanner;

public class Main {
	static int[] arr;
	static int N, M;
	static StringBuilder ans = new StringBuilder();
	public static void permu(int dep, int pre) {
		if(dep == M) {
			for(int i=0; i<M; i++) ans.append(arr[i]+" ");
			ans.append("\n");
			return;
		}
		for(int i=pre; i<N; i++) {
			arr[dep]= i+1;
			permu(dep+1, i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		arr = new int[M];
		permu(0, 0);
		System.out.println(ans.toString());
	}
}
