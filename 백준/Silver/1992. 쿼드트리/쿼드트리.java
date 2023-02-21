import java.util.Scanner;

public class Main{
	static StringBuilder ans = new StringBuilder();
	static int[] dx= {0, 1, 0, 0}, dy = {1, -1, 1, 0};
	static int[][] arr;
	static boolean flag;
	public static void divide(int x, int y, int siz) {
		ans.append('('); 
		siz /= 2;
		for(int k=0; k<4; k++) {
			int tmp = 0;
			for(int i=x; i<x+siz; i++) {
				for(int j=y; j<y+siz; j++) {
					tmp += arr[i][j];
				}
			}
			if(tmp == siz*siz || tmp == 0) {
				if(tmp == 0) ans.append('0');
				else ans.append('1');
			}
			else divide(x, y, siz);
			x += siz*dx[k]; y += siz*dy[k];
		}
		ans.append(')');
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), check = 0;
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			char[] tmp = sc.next().toCharArray();
			for(int j=0; j<N; j++) {
				if(tmp[j] == '1') check++;
				arr[i][j]= tmp[j] - '0';
			}
		}
		if(check == N*N) System.out.println(1);
		else if(check == 0) System.out.println(0);
		else {divide(0, 0, N); System.out.println(ans.toString());}
	}
}
