import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		char[][] arr = {
				{'0','0','0','0','0','0'},
				{'0','0','1','1','1','1'},
				{'0','1','0','0','1','1'},
				{'0','1','1','1','0','0'},
				{'1','0','0','1','1','0'},
				{'1','0','1','0','0','1'},
				{'1','1','0','1','0','1'},
				{'1','1','1','0','1','0'}
		};
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String answer= "";
		String str1 = sc.next();
		sc.close();
		for(int c=0; c<N; c++) {
			boolean find = false;
			for(int alpa=0; alpa<8; alpa++) {
				int diff = 0;
				for(int i=0; i<6; i++) {
					if(arr[alpa][i] != str1.charAt(c*6 + i)) {diff += 1;}
				}
				if(diff < 2) {
					find = true;
					answer = answer + (char)(alpa+'A');
				}
			}
			if(!find) {
				System.out.println(c+1);
				System.exit(0);
			}
		}
		System.out.println(answer);
	}
	
}