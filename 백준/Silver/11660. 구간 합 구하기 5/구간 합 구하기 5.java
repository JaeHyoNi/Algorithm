
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		int x1,y1,x2,y2,N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		for(int i=1; i<=N;i++) {for(int j=1;j<=N; j++) {arr[i][j] = sc.nextInt(); arr[i][j]+= arr[i][j-1];}}
		for(int i=1; i<=N;i++) {for(int j=1;j<=N; j++) {arr[i][j]+= arr[i-1][j];} }

		for(int k=0; k<M; k++) {
			x1=sc.nextInt(); y1=sc.nextInt();x2=sc.nextInt();y2=sc.nextInt();
			str.append(arr[x2][y2] - arr[x1-1][y2]-arr[x2][y1-1]+arr[x1-1][y1-1]).append("\n");
		}
		System.out.println(str.toString());
	}
}
