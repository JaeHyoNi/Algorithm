import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int[] dx = {0, 1, 0,-1}, dy = {1,0,-1,0};
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
			int num = 1,d=0, x=0, y=0, nx=0, ny=0, K=N*N;
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) { arr[i] = new int[N];}
			while(num <= K) {
				arr[x][y]= num++;
				nx=x+dx[d]; ny=y+dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=N || arr[nx][ny]!=0) {d = (d+1)%4;}
				x+=dx[d]; y+=dy[d];
			}
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {for(int j=0; j<N; j++) {System.out.print(arr[i][j]+" ");}System.out.println();}
		}
	}
}