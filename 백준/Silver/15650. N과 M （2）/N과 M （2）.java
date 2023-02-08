import java.util.Scanner;

public class Main {
	static int[] arr = new int[9];
	static int N, M;
	public static void permu(int dep, int k) {
		if(dep == M) {
			for(int i=0; i<M; i++) {System.out.print(arr[i]+" ");}
			System.out.println();
			return;
		}
		for(int i=k+1; i<=N;i++) {
			arr[dep]=i;
			permu(dep+1, i);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		permu(0, 0);
	}
}
