import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = {2,3,5,7,11};
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			System.out.print("#"+tc+" ");
			for(int i=0; i<5; i++) {
				int temp = 0;
				while(N% arr[i] == 0) {
					N /= arr[i];
					temp ++;
				}
				System.out.print(temp+" ");
			}System.out.println();
		}
	}
}
