import java.util.*;

public class Main{
	static int[] arr;
	static int moum = 1065233, jaum=Integer.MAX_VALUE, L, C;
	static StringBuilder ans = new StringBuilder();
	public static void dfs(int now, int pre, int select) {
		if(now == L) {
			if((moum & select) == 0) return;
			int check = select & jaum, num = 0;
			for(int i=0; i<=26; i++) {
				if((check & (1<<i)) > 0) num++;
			}
			if(num < 2) return;
			for(int i=0; i<26; i++) {
				if((select & (1<<i)) > 0) 
					ans.append((char)(i+'a'));
			} ans.append('\n');
			return;
		}
		for(int i=pre; i<C; i++) {
			if((select & (1<<arr[i])) == 0) 
				dfs(now+1, i+1, select | (1<<arr[i]));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt(); C = sc.nextInt();
		arr = new int[C];
		for(int i=0; i<C; i++) arr[i]= sc.next().charAt(0)-'a';
		Arrays.sort(arr);
		jaum ^= moum;
		dfs(0, 0, 0);
		System.out.println(ans);
	}
}