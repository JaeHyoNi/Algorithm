
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] friendnum;
	
	public static int find_parent(int x) {
		if(arr[x] == x) return x;
		else return arr[x] = find_parent(arr[x]); 
	}
	
	public static void union(int x, int y) {
		int a = find_parent(x), b = find_parent(y);
		if(a==b) return;
		if(a>b) {
			friendnum[b]+= friendnum[a];
			arr[a]=b;
		}
		else {
			friendnum[a]+= friendnum[b];
			arr[b]=a; 
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		String f1, f2;
		for(int k=0; k<T; k++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[2*N+1];
			friendnum = new int[2*N+1];
			for(int i=0; i<2*N+1; i++) {arr[i]= i; friendnum[i] = 1;}  
			int flag = 0;
			HashMap<String, Integer> friend = new HashMap<String, Integer>();
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				f1 = st.nextToken(); f2 = st.nextToken();
				if(!friend.containsKey(f1)) friend.put(f1, flag++);
				if(!friend.containsKey(f2)) friend.put(f2, flag++);
				union(friend.get(f1), friend.get(f2));
				answer.append(friendnum[find_parent(friend.get(f1))]+"\n");
			}
		}
		System.out.print(answer.toString());
	}
}
