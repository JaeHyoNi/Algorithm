import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			for(int i=0; i<100; i++) {arr[i] = sc.nextInt();}
			Arrays.sort(arr);
			for(int i=0; i<N; i++) {
				if(arr[0] == arr[99]) break;
				arr[0] += 1; arr[99] -= 1;
				Arrays.sort(arr);
			}
			System.out.printf("#%d %d\n",tc, arr[99] - arr[0]);
		}
	}
}