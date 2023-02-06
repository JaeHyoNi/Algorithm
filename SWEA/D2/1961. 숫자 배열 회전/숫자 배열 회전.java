import java.util.Scanner;
public class Solution {
	static int[][] arr;
	static int N;
	public static int[][] right90() {
		int[][] temp = new int[N][N];
		for(int i=0; i<N; i++) {for(int j=0; j<N; j++) {temp[i][j] = arr[N-j-1][i];}}
		arr = temp;
		return temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			for(int i=0; i<N; i++) {for(int j=0; j<N; j++) {arr[i][j] = sc.nextInt();}}
			int[][][] temp = new int[3][N][N];
            System.out.println("#" + tc);
			for(int i=0; i<3; i++) {temp[i] = right90();}
			for(int i=0; i<N; i++) {
				for(int j=0; j<3; j++) {
					for(int k=0; k<N; k++) {
						System.out.print(temp[j][i][k]);
					}
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
}
