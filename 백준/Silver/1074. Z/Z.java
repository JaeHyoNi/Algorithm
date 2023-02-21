import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt(),tmp = 1, mul, answer=0;  
	    for(int i=0;i<N;i++){tmp *= 2;}
	    N = tmp;
	    while(!(N==1)){
	    	mul = N*N/4;
	    	N /= 2;
		    if(r<N && c<N) tmp = 0;
		    else if(r<N && c>=N) tmp = 1;
		    else if(r>=N && c<N) tmp = 2;
		    else tmp = 3;
		    answer += mul*tmp;
	        if(tmp == 0){}
	        else if(tmp == 1) c -= N; 
	        else if(tmp == 2) r -= N;
	        else {r-=N; c-=N;}
	    }
	    System.out.println(answer);
	}
}
