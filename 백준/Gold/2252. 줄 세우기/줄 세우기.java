import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder str = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		ArrayList<Integer>[] road = new ArrayList[N+1];
		for(int i=0; i<=N; i++) road[i]= new ArrayList<>(); 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
			road[f].add(t);
			arr[t]+= 1; 
		}
		Queue<Integer> wait = new ArrayDeque<>();
		for(int i=1; i<=N; i++) if(arr[i]== 0 ) wait.add(i);
		while(!wait.isEmpty()) {
			int n = wait.poll(); 
			str.append(n + " ");
			for(int i=0; i<road[n].size(); i++) {
				arr[road[n].get(i)] -= 1;
				if(arr[road[n].get(i)]== 0) wait.add(road[n].get(i));
			}
		}
		System.out.println(str);
	}
}
