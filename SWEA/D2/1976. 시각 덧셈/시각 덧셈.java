import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int h1=sc.nextInt(), m1=sc.nextInt(), h2=sc.nextInt(), m2=sc.nextInt();
			int h3 = (h1+h2)%12, m3 = m1+m2;
			if(m3>=60) {h3+=1; m3-=60;}
			System.out.printf("#%d %d %d\n", tc, h3, m3);
		}
	}
}
