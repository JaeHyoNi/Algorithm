import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder ans = new StringBuilder();
		int[] answer = new int[T];
		Integer[] arr = new Integer[T];
		Stack<Integer> stack = new Stack<Integer>(); 
		for(int i=0; i<T; i++) {arr[i]= Integer.parseInt(st.nextToken()); }
		for(int i=0; i<T; i++) {
			if(stack.isEmpty()) {stack.add(i);}
			else if(arr[stack.peek()] > arr[i]) {
				answer[i]= stack.peek(); 
				stack.add(i);
			}
			else if(arr[stack.peek()] < arr[i]) {
				int temp;
				while(!stack.empty() && arr[stack.peek()] <= arr[i]) {
					temp = stack.pop();
					if(stack.empty()) break;
					answer[temp] = stack.peek() + 1;
				}
				stack.add(i);
			}
		}
		while(!stack.empty()) {
			int temp = stack.pop();
			if(stack.empty()) break;
			answer[temp] = stack.peek() + 1;
		}
		for(int i = 0; i< answer.length; i++) {ans.append(answer[i]+" ");}
		System.out.println(ans.toString());
	}
}
