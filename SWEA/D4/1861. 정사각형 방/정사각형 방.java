import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(str.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			str = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(str.nextToken());
			int[][] arr = new int[N][N];
			int[] x=new int[N*N+1], y = new int[N*N+1], answer = new int[N*N+1];
			for(int i=0;i<N;i++) {
				str = new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]= Integer.parseInt(str.nextToken()); 
					x[arr[i][j]] = i;
					y[arr[i][j]] = j;
				}
			}
			answer[1] = 1;
			int ind=1, ans=1;
			for(int i=1; i<N*N; i++) {
				if((Math.abs(x[i]-x[i+1]) + Math.abs(y[i]-y[i+1])) == 1) {
					answer[i+1] = answer[i] + 1; 
					if(answer[i+1] > ans) {
						ans = answer[i+1];
						ind = i+1;
					}
				}
				else {answer[i+1] = 1;}
			}
			sb.append("#" + tc +" " + (ind-ans+1) + " " + ans+"\n");
		}
		System.out.println(sb.toString());
	}
}


