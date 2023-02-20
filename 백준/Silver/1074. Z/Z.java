import java.util.Scanner;

public class Main {
	public static int division4(int x, int y, int N) {
		N /= 2;
	    if(x<N && y<N) return 0;
	    if(x<N && y>=N) return 1;
	    if(x>=N && y<N) return 2;
	    return 3;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt(),tmp = 1, mul, answer=0;  
	    for(int i=0;i<N;i++){tmp *= 2;}
	    N = tmp;
	    while(!(N==1)){
	        tmp = division4(r,c,N);
	        mul = N*N/4;
	        answer += mul*tmp;
	        N /= 2;
	        if(tmp == 0){}
	        else if(tmp == 1) c -= N; 
	        else if(tmp == 2) r -= N;
	        else {r-=N; c-=N;}
	    }
	    System.out.println(answer);
	}
}
