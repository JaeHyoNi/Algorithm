import java.util.Scanner;

public class Solution{
	static int ans, N, va, n, T;
	static int[][] R = new int[13][13], V = new int[12][2], M = new int[12][1<<12];
	static void tsp(int r, int v, int d){
	    if(v==va){ans = Math.min(ans, d+R[r][1]); return;}
	    else{
	        for(int i=2; i<N+2; i++){
	            if((1<<i&v)==0){
	                n = v | 1<<i;
	                if(M[i][n] > d+R[r][i]){
	                    M[i][n] = d+R[r][i];
	                    tsp(i, n, M[i][n]);
	                }
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	    for(int t=1; t<=T; t++){
	        N = sc.nextInt();
	        int i, j;
	        ans=9999;
	        for(i=0; i<12; i++){for(j=0; j<(1<<(N+2)); j++){ M[i][j]=9999; }}
	        for(j=0;j<N+2;j++){
	        	V[j][0] = sc.nextInt();  V[j][1] = sc.nextInt();
	        }
	        for(i=0;i<N+2;i++){
	        	for(j=0; j<N+2; j++){
	        		R[i][j] = Math.abs(V[i][0]-V[j][0])+Math.abs(V[i][1]-V[j][1]);
        		}
        	}
	        va = (1<<(N+2))-3;
	        tsp(0, 1, 0);
	        System.out.printf("#%d %d\n", t, ans);
	    }
	}
}
