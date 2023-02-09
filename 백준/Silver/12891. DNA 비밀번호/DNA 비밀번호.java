import java.util.Scanner;

public class Main {
	static int[] min = new int[26];
	static int[] now = new int[26];
	static int ans = 0;
	static int[] alpa = {0,2,6,19}; 
	public static void check() {
		for(int i: alpa) {if(now[i] < min[i]) return;}
		ans += 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S=sc.nextInt(), P = sc.nextInt();
		String str = sc.next();
		for(int i=0; i<4; i++) {min[alpa[i]] = sc.nextInt();}
		for(int i=0; i<P; i++) {now[str.charAt(i)-'A'] += 1;}
		check();
		int temp = S - P;
		for(int i=0; i<temp; i++) {
			now[str.charAt(i)-'A'] -= 1;
			now[str.charAt(i+P)-'A'] += 1;
			check();
		}
		System.out.println(ans);
	}
}
