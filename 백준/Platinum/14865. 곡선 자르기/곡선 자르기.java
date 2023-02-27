import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> xs = new ArrayList<>();
		ArrayList<Character> str = new ArrayList<>();
		HashMap<Integer, Character> hm = new HashMap<>();
		int tmp = 0, ind = 0,mx=Integer.MAX_VALUE, my = Integer.MAX_VALUE; 
		int px, py, nx, ny, N = Integer.parseInt(br.readLine());
		boolean flag = false;
		Integer[] x = new Integer[N], y = new Integer[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken()); 
			y[i]=Integer.parseInt(st.nextToken());
			if(x[i]< mx) {mx = x[i]; my = y[i]; ind = i;}
			else if(x[i]==mx && y[i]< my) {my = y[i]; ind = i;}
		}
		px = mx; py = my;
		for(int k=0; k<N; k++) {
			if(ind >= N) ind -= N;
			if(py * y[ind] >= 0) {px = x[ind]; py = y[ind]; ind += 1;continue; }
			if(!flag) {
				flag = true;
				xs.add(x[ind]);
				tmp = x[ind];
			}
			else {
				flag = false;
				xs.add(x[ind]);
				if(x[ind] > tmp) {
					hm.put(x[ind], ')');  hm.put(tmp, '(');
				} else {
					hm.put(x[ind], '(');  hm.put(tmp, ')');
				}
			}
			px = x[ind]; py = y[ind];
			ind += 1;
		}
		Collections.sort(xs);
		int a = 0, b = 0;
		tmp = 0;
		for(int i=0; i< xs.size(); i++) {str.add(hm.get(xs.get(i)));}
		for(int i=0; i<str.size(); i++) {
			if(str.get(i) == '(' ) {
				tmp += 1;
				if(str.get(i+1) == ')') b+=1;
			}
			else {
				if(tmp == 1) a+=1;
				tmp -= 1;
			}
		}
		System.out.println(a+" "+b);
	}
}
