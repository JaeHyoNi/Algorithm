import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][][] crush;
		int[][] arr;
		int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
		int nx, ny, iter = 1;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String tmp;
		int siz=0, N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		arr = new int[N][M]; crush = new int[N][M][2];
		for(int i=0; i<N; i++) {
			tmp = bf.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j]=  (int)(tmp.charAt(j) - '0');
			}
		}
		Integer[] n;
		Queue<Integer[]> wait = new ArrayDeque<Integer[]>();
		// {x, y, 벽뚫기 사용}
		wait.add(new Integer[] {0, 0, 0});
		if(N==1 && M==1) {System.out.println("1"); System.exit(0);}
		while(!wait.isEmpty()) {
			siz = wait.size();
			iter++;
			for(int k=0; k<siz; k++) {
				n = wait.poll();
				for(int i=0; i<4; i++) {
					nx = n[0] + dx[i]; ny = n[1] + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(arr[nx][ny]==1 && n[2] == 0 && crush[nx][ny][1] == 0) {
						if(nx == N-1 && ny == M-1) {
							System.out.println(iter);
							System.exit(0);
						}
						crush[nx][ny][1]= 1;
						wait.add(new Integer[] {nx, ny, 1});
						continue;
					}
					if(arr[nx][ny]==0 && crush[nx][ny][n[2]] == 0) {
						if(nx == N-1 && ny == M-1) {
							System.out.println(iter);
							System.exit(0);
						}
						crush[nx][ny][n[2]] = 1;
						wait.add(new Integer[] {nx, ny, n[2]});
					}
				}
			}
		}
		System.out.println("-1");
	}
}
