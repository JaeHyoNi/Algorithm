import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N1=sc.nextInt(), N2=sc.nextInt();
			HashSet<String> s1=new HashSet<>(), s2=new HashSet<>();
			for(int i=0; i<N1; i++) s1.add(sc.next());
			for(int i=0; i<N2; i++) s2.add(sc.next());
			s2.retainAll(s1);
			System.out.printf("#%d %d\n", tc, s2.size() );
		}
	}
}