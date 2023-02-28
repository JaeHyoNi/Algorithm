import java.util.*;

public class Solution {
	static class p{int x; int y; public p(int x, int y) {this.x=x; this.y=y;}};
	static int N, W, H, ans, siz;
	static int[] dx= {-1,0,1,0}, dy= {0, 1, 0, -1};
	static void DFS(int[][] arr, int dep, int num) {
		if(N == dep) {if(siz-num < ans) ans = siz-num; return;}
		boolean[][] visited;
		Queue<p> wait;
		for(int i=0; i<W; i++) {
			int k = 0, bomb=0, nx, ny;
			p tp;
			while(k<H && arr[k][i]== 0) k++;
			if(k == H) continue;
			visited = new boolean[H][W];
			wait = new ArrayDeque<p>();
			wait.add(new p(k, i));
			visited[k][i] = true;
			// 폭탄을 떄리면서 BFS한번 돔
			while(!wait.isEmpty()) {
				tp = wait.poll();
				for(int j=0; j<4; j++) {
					for(int m=1; m<arr[tp.x][tp.y]; m++) {
						nx = tp.x + dx[j]*m;  ny = tp.y + dy[j]*m;
						if(nx<0 || ny<0 || nx>=H || ny >= W || visited[nx][ny] || arr[nx][ny]== 0) continue;
						visited[nx][ny]= true;
						wait.add(new p(nx, ny));
						bomb += 1;
					}
				}
			}
			//폭탄 체크 다 했으면 배열 바꾸고 DFS
			int[][] tmp = new int[H][W];
			for(int w = 0; w < W; w++) {
				int index = H-1;
				for(int h = H-1; h>=0; h--) {
					if(arr[h][w] != 0 && !visited[h][w] ) tmp[index--][w] = arr[h][w];
				}
			}
			DFS(tmp, dep+1, num + bomb+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt(); W=sc.nextInt(); H=sc.nextInt(); siz=0;  ans = 999999;
			int[][] arr = new int[H][W];
			for(int i=0; i<H; i++) for(int j=0; j<W; j++) {
				arr[i][j]= sc.nextInt();
				if(arr[i][j] != 0) siz+=1;
			}
			DFS(arr, 0, 0);
			if(ans == 999999) ans = 0;
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
}