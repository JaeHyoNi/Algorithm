import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] num;
	static boolean[] visited;
	static int N, M;
	static StringBuilder ans = new StringBuilder();
	public static void permu(int dep) {
		if(dep == M) {
			for(int i=0; i<M; i++) ans.append(arr[i]+" ");
			ans.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i]= true; 
			arr[dep]= num[i];
			permu(dep+1);
			visited[i]= false; 
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		num = new int[N];
		for(int i=0; i<N; i++) {num[i]= sc.nextInt();}
		Arrays.sort(num);
		arr = new int[N+1];
		visited = new boolean[N+1];
		permu(0);
		System.out.println(ans.toString());
	}
}
