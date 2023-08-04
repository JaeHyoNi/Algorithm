import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine(), P=sc.nextLine();
		int i=0, j=1, sizT=T.length(), sizP=P.length();
		int[] lps = new int[sizP];
		ArrayList<Integer> ans=new ArrayList<>();
		while(j < sizP) {
			if(P.charAt(i)==P.charAt(j)) lps[j++]= ++i; 
			else {
				if(i==0) lps[j++]=0;
				else i=lps[i-1];
			}
		}
		i=0; j=0;
		while(i<sizT) {
			if(j==sizP) {ans.add(i-sizP+1); j=lps[j-1];}
			if(T.charAt(i)==P.charAt(j)) {i++; j++;}
			else {
				if(j==0) i++;
				else j=lps[j-1];
			}
		}
		if(j==sizP) ans.add(i-sizP+1);
		System.out.println(ans.size());
		for(Integer K: ans) System.out.print(K+" ");
	}
}
