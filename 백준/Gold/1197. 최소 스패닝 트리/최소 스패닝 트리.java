import java.io.*;
import java.util.*;

public class Main {
	static class p implements Comparable<p>{
		int from; int to; int val; 
		public p(int from, int to, int val) {this.from = from;this.to=to; this.val=val;}
		@Override
		public int compareTo(p o) { return this.val - o.val;}
	}
	static int[] mother;
	static int find_mother(int x) {
		if(mother[x]== x ) return x;
		return mother[x] = find_mother(mother[x]); 
	}
	static boolean union(int a, int b) {
		int aa= find_mother(a), bb = find_mother(b);
		if(aa==bb) return false;
		mother[aa]= mother[bb]= Math.min(aa, bb);
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        mother = new int[N+1];
        for(int i=0; i<N+1; i++) mother[i]= i; 
        p[] road = new p[M];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            road[i]= new p(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(road);
        boolean[] visited = new boolean[N+1];
        int num = 0, ans = 0;
        for(int i=0; i<M; i++) {
            int f = find_mother(road[i].from), t = find_mother(road[i].to);
            if(!union(f, t)) continue;
            visited[f]= visited[t]= true;  
            ans += road[i].val;
            num += 1;
            if(num == N-1) break;
        }
        System.out.print(ans);
	}
}
