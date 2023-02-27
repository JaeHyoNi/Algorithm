import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] arr = new int[101][101];
    static int[] xs, ys;
    static int ans;
    static int visited[][] =  new int[101][101];

    static void check(int x, int y) {
        int nx, ny;
        if(visited[x][y]==1) return;
        visited[x][y] = 1;
        for(int i=0; i<4; i++) {
            nx = x + dx[i]; ny = y + dy[i];
            if(nx < 0 || nx >100 || ny < 0 || ny > 100) continue;
            if(arr[nx][ny] == 0) ans += 1;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x, y, N = Integer.parseInt(br.readLine());
        xs = new int[N]; ys = new int[N];
        for(int k=0; k<N; k++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            xs[k] = x; ys[k] = y;
            for(int i=x; i<=x+9; i++) {for(int j=y; j<=y+9;j++) {
                arr[i][j] = 1;
            }}
        }
        for(int k=0; k<N; k++) {
            for(x = xs[k]; x<=xs[k]+9; x++) check(x, ys[k]);
            for(x = xs[k]; x<=xs[k]+9; x++) check(x, ys[k]+9);
            for(y = ys[k]; y<=ys[k]+9; y++) check(xs[k], y);
            for(y = ys[k]; y<=ys[k]+9; y++) check(xs[k]+9, y);
        }
        System.out.println(ans);
    }
}
