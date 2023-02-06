import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			String str = "";
			for(int i=0; i<N; i++) {
				char n = sc.next().charAt(0);
				int h = sc.nextInt();
				for(int k=0; k<h; k++) str += n;
			}
			System.out.print("#"+tc);
			for(int i=0; i<str.length(); i++) {
				if(i % 10 == 0) {System.out.println();}
				System.out.print(str.charAt(i));
			}System.out.println();
		}
	}
}
