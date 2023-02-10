import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		boolean visited[] = new boolean[T+1];
		int i = 1, N = T;
		boolean flag = false;
		while(N>1) {
			while(visited[i]) {
				i++;
				if(i>T) i=1;
			}
			if(!flag) {visited[i]= true; N--;}
			flag = !flag;
			i = i+1; 
			if(i>T) i =1;
		}
		for(i=1; i<=T; i++) {
			if(!visited[i]) { System.out.println(i); break;}
		}
	}
}
 
