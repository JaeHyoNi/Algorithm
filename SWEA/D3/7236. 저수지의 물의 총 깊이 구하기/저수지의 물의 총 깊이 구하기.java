import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx= {-1,-1,-1,0,0,1,1,1}, dy={-1,0,1,-1,1,-1,0,1};
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			Character[][] arr = new Character[N][N];
			for(int i=0;i<N;i++) {for(int j=0;j<N;j++) arr[i][j] = sc.next().charAt(0);}
			int tmp, max=0,nx,ny;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					tmp = 0;
					for(int k=0; k<8; k++) {
						nx = i+dx[k]; ny = j+dy[k];
						if(0<=nx && nx<N && 0<=ny && ny<N && arr[nx][ny]=='W') {
							tmp += 1;
						}
					}
					if(tmp == 0) tmp = 1;
					max = tmp > max ? tmp : max;
				}
			}
			System.out.printf("#%d %d\n",tc, max);
		}
	}
}
