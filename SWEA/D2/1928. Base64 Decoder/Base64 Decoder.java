import java.util.HashMap;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		char n = 'A';
		int i=0;
		for(i=0; i<26; i++) {hm.put(n++,i);} n = 'a';
		for(i=i; i<52; i++) {hm.put(n++,i);} n = '0';
		for(i=i; i<62; i++) {hm.put(n++,i);}
		hm.put('+', 62); hm.put('/', 63);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			String bin = "";
			for(i=0; i<str.length(); i++) {
				if((int)str.charAt(i) > '0') {}
				bin += String.format("%06d",Integer.parseInt(Integer.toBinaryString(hm.get(str.charAt(i)))));
			}
            System.out.print("#"+tc+" ");
			for(i=0; i<bin.length()/8; i++) {
				System.out.print((char)(Integer.parseInt(bin.substring(i*8, i*8 + 8),2)));
			}
			System.out.println();
		}
	}
}
