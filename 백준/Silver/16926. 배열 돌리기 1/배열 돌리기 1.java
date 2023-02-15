import java.util.Scanner;

public class Main {
	static int N, M, R;
	static int[][] arr;
	static int[] dx= {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void goleft(int a, int b) {
		int time = R % ((N-a*2)*2 + 2*(M-a*2-2));
		int x, y, col, row,temp;
		col = M-a*2-1;
		row = N-b*2-1;
		for(int m=0; m<time; m++) {
			int dir = 0;
			x=a; y=b;
			temp = arr[a][b];
			for(int k=0; k<2; k++) {
				for(int i=0; i<col; i++) {
					arr[x][y]= arr[x+dx[dir]][y+dy[dir]];
					x += dx[dir]; y += dy[dir];
				}
				dir += 1;
				for(int i=0; i<row; i++) {
					arr[x][y]= arr[x+dx[dir]][y+dy[dir]];
					x += dx[dir]; y += dy[dir];
				}
				dir += 1;
			}
			arr[x+1][y]= temp; 
		}
	}
	
	public static void cycleleft() {
		int temp = N > M ? M : N;
		for(int i=0; i<temp/2; i++) goleft(i, i);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt(); M=sc.nextInt(); R = sc.nextInt();
		StringBuilder st = new StringBuilder();
		arr = new int[N][M];
		for(int i=0; i<N; i++) {for(int j=0; j<M; j++) {arr[i][j]= sc.nextInt();}}
		cycleleft();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				st.append(arr[i][j]+ " " );
			}st.append("\n");
		}
		System.out.println(st.toString());
	}
}
