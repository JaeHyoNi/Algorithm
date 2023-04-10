import java.io.*;
import java.util.*;
class p{int x,y; char c; p(int x, int y,char c){this.x=x; this.y=y; this.c = c;}}
public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String tmp;
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		Queue<p> wait = new ArrayDeque<>();
		Character arr[][] = new Character[R][C];
		int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
		for(int i=0; i<R; i++) {
			tmp = bf.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j]= tmp.charAt(j);
				if(arr[i][j]== '*') wait.add(new p(i, j, '*'));
			}
		}
		for(int i=0; i<R; i++) for(int j=0; j<C; j++) if(arr[i][j]== 'S' ) wait.add(new p(i, j, 'S')); 
		int ans = 0, x, y, nx, ny;
		Character c;
		while(!wait.isEmpty()) {
			ans += 1;
			int siz = wait.size();
			for(int i=0; i<siz; i++) {
				x = wait.peek().x; y = wait.peek().y; c = wait.peek().c; wait.poll();
				for(int k=0; k<4; k++) {
					nx = x + dx[k]; ny = y + dy[k];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny]=='X') continue;
					if(c == 'S' && arr[nx][ny]=='D') {
						System.out.print(ans); System.exit(0);
					}
					if(c == 'S') {if(arr[nx][ny]!= '.' )  continue;}
					else if(arr[nx][ny]!='.' && arr[nx][ny]!='S') continue;
					arr[nx][ny]= c;
					wait.add(new p(nx, ny, c));
				}
			}
		}
		System.out.print("KAKTUS");
	}
}
