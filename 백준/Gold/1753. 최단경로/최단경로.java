import java.io.*;
import java.util.*;

public class Main{
	static class p implements Comparable<p>{int to; int val; public p(int to, int val) {this.to=to; this.val=val;}

	@Override
	public int compareTo(p o) {
		return this.val - o.val;
	}}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken()), E=Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		int[] road = new int[V+1];
		List<p> arr[]= new ArrayList[V+1];
		for(int i=1; i<=V; i++) arr[i]= new ArrayList<>(); 
		Arrays.fill(road, 999999);
		road[s]= 0; 
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int val=Integer.parseInt(st.nextToken());
			arr[from].add(new p(to, val));
		}
		PriorityQueue<p> wait = new PriorityQueue<>();
		wait.offer(new p(s, 0));
		while(!wait.isEmpty()) {
			p tmp = wait.poll();
			if(road[tmp.to] < tmp.val) continue;
			road[tmp.to]= tmp.val;
			for(int i=0; i<arr[tmp.to].size(); i++) {
				p tmp2 = arr[tmp.to].get(i);
				if(road[tmp.to]+tmp2.val < road[tmp2.to])
					wait.offer(new p(tmp2.to, road[tmp.to]+ tmp2.val ));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			sb.append((road[i]== 999999 ? "INF" : road[i]) + "\n");
		}
		System.out.println(sb.toString());
	}
}
