import java.util.Arrays;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.print("#"+tc+" ");
			for(int K: arr) {
				System.out.print(K+" ");
			}
			System.out.println();
		}
	}
}
