import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		int arr[] = {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String s1=sc.next(), s2=sc.next();
			if(s1.length() != s2.length()) {
				System.out.printf("#%d DIFF\n",tc);
				continue;
			}
			boolean is = true;
			for(int i=0; i<s1.length(); i++) {
				if(arr[(int)s1.charAt(i)-(int)'A'] != arr[(int)s2.charAt(i)-(int)'A']) {
					is = false;
					break;
				}
			}
			if(is) System.out.printf("#%d SAME\n",tc);
			else System.out.printf("#%d DIFF\n",tc);
		}
	}
}
