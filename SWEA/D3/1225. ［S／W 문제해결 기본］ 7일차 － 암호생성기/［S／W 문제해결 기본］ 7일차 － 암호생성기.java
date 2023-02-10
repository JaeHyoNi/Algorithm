import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc,i,flag;
		int[] arr = new int[8];
		for(int t=0; t<10; t++) {
			tc = sc.nextInt();
			flag = 1; i = 0;
			for(int k=0; k<8; k++) {arr[k]= sc.nextInt(); }
			while(true) {
				arr[i] -= flag++;
				if(flag == 6) flag = 1;
				if(arr[i] <= 0 ) {arr[i++]= 0; break;}
				i += 1;
				if(i==8) i=0;
			}
			System.out.print("#"+tc+" ");
			for(int k=0; k<8; k++) {
				System.out.print(arr[i++]+" ");
				if(i==8) i=0;
			}
			System.out.println();
		}
	}
}
