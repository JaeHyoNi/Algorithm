import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
class pair{
	int x,y;
	public pair(int x, int y) {
		this.x = x; this.y = y;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder ans = new StringBuilder();
		int[] answer = new int[T];
		Integer[] arr = new Integer[T];
		Stack<pair> stack = new Stack<pair>(); 
		for(int i=0; i<T; i++) {arr[i]= Integer.parseInt(st.nextToken()); }
		for(int i=0; i<T; i++) {
			if(stack.isEmpty()) {stack.add(new pair(i, arr[i]));}
			else if(stack.peek().y > arr[i]) {
				answer[i]= stack.peek().x; 
				stack.add(new pair(i, arr[i]));
			}
			else if(stack.peek().y < arr[i]) {
				pair temp;
				while(!stack.empty() && stack.peek().y <= arr[i]) {
					temp = stack.pop();
					if(stack.empty()) break;
					answer[temp.x] = stack.peek().x + 1;
				}
				stack.add(new pair(i, arr[i]));
			}
		}
		while(!stack.empty()) {
			int temp = stack.pop().x;
			if(stack.empty()) break;
			answer[temp] = stack.peek().x + 1;
		}
		for(int i = 0; i< answer.length; i++) {ans.append(answer[i]+" ");}
		System.out.println(ans.toString());
	}
}
