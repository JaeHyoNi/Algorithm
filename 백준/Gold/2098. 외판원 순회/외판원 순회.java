import java.io.*;
import java.util.*;
public class Main{
    static int N, arr[][], dp[][],ans = Integer.MAX_VALUE;
    static int tsp(int visited, int pre){
        if(visited+1 == (1<<N)){return (arr[pre][0] != 0) ? arr[pre][0] : 200000000;}
        if(dp[pre][visited] != 0 ) return dp[pre][visited];
        int tmp = 200000000;
        for(int i=0; i<N; i++){
            if(arr[pre][i] == 0 || (visited & (1<<i)) > 0 ) continue;
            tmp = Math.min(tmp, tsp((visited | (1<<i)), i) + arr[pre][i]);
        }
        return dp[pre][visited] = tmp;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N]; dp = new int[N][1<<N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dp[0][1] = 0;
        ans = tsp(1, 0);
        System.out.println(ans);
    }
}
