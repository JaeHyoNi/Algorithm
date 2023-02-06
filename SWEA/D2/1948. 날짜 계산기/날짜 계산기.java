import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		for(int tc=1; tc<=T; tc++) {
			int m1=sc.nextInt(),d1=sc.nextInt(),m2=sc.nextInt(),d2=sc.nextInt();
			int sum=0;
			for(int i=m1; i<m2; i++) {
				sum += arr[i];
			}
			sum = sum - d1 + d2 + 1;
			System.out.printf("#%d %d\n",tc,sum);
		}
	}
}
