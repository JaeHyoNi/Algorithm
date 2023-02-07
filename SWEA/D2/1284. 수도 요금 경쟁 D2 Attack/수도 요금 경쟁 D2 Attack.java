import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int P=sc.nextInt(), Q=sc.nextInt(), R=sc.nextInt(),S=sc.nextInt(),W=sc.nextInt();
			System.out.printf("#%d %d\n",tc, Math.min(P*W, W < R ? Q : Q + S*(W-R)));
		}
	}
}
