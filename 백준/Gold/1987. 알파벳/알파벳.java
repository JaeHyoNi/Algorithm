import java.util.*;

public class Main{
	static int ans, visited, N, M;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static char[][] arr;
	public static void dfs(int visited, int x, int y, int num) {
		int nx, ny;
		for(int i=0; i<4; i++) {
			nx = x + dx[i]; ny = y + dy[i];
			if(0<=nx && nx<N && 0<=ny && ny<M && (((1 << (arr[nx][ny]-'A')) & visited) == 0)) {
				dfs(visited | (1<<(arr[nx][ny]-'A')), nx, ny, num+1);
			}
		}
		ans = ans > num ? ans : num;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		arr = new char[N][];
		for(int i=0; i<N; i++) arr[i]= sc.next().toCharArray();
		dfs(1<<arr[0][0]-'A', 0, 0, 1);
		System.out.println(ans);
	}
}