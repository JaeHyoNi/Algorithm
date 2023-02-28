import java.util.*;

public class Solution {
	static class p{int x;int y;public p(int x, int y) {this.x = x;this.y = y;}}
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] arr= new int[N][N];
			char[] tmp;
			for(int i=0; i<N; i++) {
				tmp = sc.next().toCharArray();
				for(int j=0; j<N; j++) {
					arr[i][j] = tmp[j]- '0'; 
				}
			}
			int[][] gogo = new int[N][N];
			p tp;
			for(int i=0; i<N; i++) for(int j=0; j<N; j++) gogo[i][j]= 9999; 
			Queue<p> wait = new ArrayDeque<p>();
			wait.add(new p(0, 0));
			gogo[0][0] = 0;
			while(!wait.isEmpty()) {
				int nx, ny;
				tp = wait.poll();
				for(int i=0; i<4; i++) {
					nx = tp.x + dx[i]; ny = tp.y + dy[i];
					if(nx<0 || ny<0 || ny>=N || nx >= N  || gogo[nx][ny] <= gogo[tp.x][tp.y]+arr[nx][ny]) continue;
					gogo[nx][ny] = gogo[tp.x][tp.y]+ arr[nx][ny];
					wait.add(new p(nx, ny));
				}
			}
			System.out.printf("#%d %d\n", tc, gogo[N-1][N-1]);
		}
	}
}