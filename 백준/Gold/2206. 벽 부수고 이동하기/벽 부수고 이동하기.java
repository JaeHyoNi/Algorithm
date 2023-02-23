import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
	static class point{
		int x, y, crush;
		public point(int x, int y, int crush) {
			this.x = x; this.y = y; this.crush = crush;
		}
	}
	static int[][][] crush;
	static char[][] arr;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int nx, ny, iter = 1;
	static point n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String tmp;
		int siz=0, N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		arr = new char[N][M]; crush = new int[N][M][2];
		for(int i=0; i<N; i++) {
			arr[i]= bf.readLine().toCharArray(); 
		}
		ArrayDeque<point> wait = new ArrayDeque<point>();
		// {x, y, 벽뚫기 사용}
		wait.add(new point(0, 0, 0));
		if(N==1 && M==1) {System.out.println("1"); System.exit(0);}
		while(!wait.isEmpty()) {
			siz = wait.size();
			iter++;
			for(int k=0; k<siz; k++) {
				n = wait.poll();
				for(int i=0; i<4; i++) {
					nx = n.x + dx[i]; ny = n.y + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(arr[nx][ny]=='1' && n.crush == 0 && crush[nx][ny][1] == 0) {
						if(nx == N-1 && ny == M-1) {
							System.out.println(iter);
							System.exit(0);
						}
						crush[nx][ny][1]= 1;
						wait.add(new point(nx, ny, 1));
						continue;
					}
					if(arr[nx][ny]=='0' && crush[nx][ny][n.crush] == 0) {
						if(nx == N-1 && ny == M-1) {
							System.out.println(iter);
							System.exit(0);
						}
						crush[nx][ny][n.crush] = 1;
						wait.add(new point(nx, ny, n.crush));
					}
				}
			}
		}
		System.out.println("-1");
	}
}
