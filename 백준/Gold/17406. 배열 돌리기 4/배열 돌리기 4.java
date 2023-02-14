import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] dx= {0, 1, 0, -1}, dy= {-1, 0, 1, 0};
	static int[] gx= {0,1,0,-1}, gy= {1, 0, -1, 0};
	static boolean[] visited;
	static int[][] li;
	static int N, M, K, ans = Integer.MAX_VALUE;
	static void cycleright(int x, int y,int k) {
		int temp = arr[x][y], dir = 0;
		for(int t=0; t<4; t++) {
			for(int m=0; m<k*2; m++) {
				arr[x][y]= arr[x+dx[dir]][y+dy[dir]]; 
				x += dx[dir]; y += dy[dir];
			}
			dir += 1;
		}
		arr[x+1][y]= temp; 
	}
	static void cycleleft(int x, int y,int k) {
		int temp = arr[x][y], dir = 0;
		for(int t=0; t<4; t++) {
			for(int m=0; m<k*2; m++) {
				arr[x][y]= arr[x+gx[dir]][y+gy[dir]]; 
				x += gx[dir]; y += gy[dir];
			}
			dir += 1;
		}
		arr[x+1][y]= temp; 
	}
	static void permu(int dep) {
		if(dep == K) {
			for(int i=0; i<N; i++) {
				ans = Math.min(Arrays.stream(arr[i]).sum(), ans);
			}
			return;
		}
		for(int i=0; i<K; i++) {
			if(!visited[i]) {
				visited[i]= true;
				for(int k=1; k<=li[i][2]; k++)
					cycleright(li[i][0]-k, li[i][1]+k, k);
				permu(dep+1);
				visited[i]= false; 
				for(int k=1; k<=li[i][2]; k++)
					cycleleft(li[i][0]-k, li[i][1]-k, k);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r,c,s;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		li = new int[K][3];
		visited = new boolean[K];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken()); 
			}
		}
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(bf.readLine());
			li[i][0] = Integer.parseInt(st.nextToken())-1;
			li[i][1] = Integer.parseInt(st.nextToken())-1;
			li[i][2] = Integer.parseInt(st.nextToken()); 
		}
		permu(0);
		System.out.println(ans);
	}
}
