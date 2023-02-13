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
		int[] answer = new int[T];
		Integer[] arr = new Integer[T];
		Stack<Integer[]> stack = new Stack<Integer[]>(); 
		for(int i=0; i<T; i++) {arr[i]= Integer.parseInt(st.nextToken()); }
		for(int i=0; i<T; i++) {
			if(stack.isEmpty()) {stack.add(new Integer[] {i, arr[i]});}
			else if(stack.peek()[1] > arr[i]) {
				answer[i]= stack.peek()[0]; 
				stack.add(new Integer[] {i, arr[i]});
			}
			else if(stack.peek()[1] < arr[i]) {
				Integer[] temp;
				while(!stack.empty() && stack.peek()[1] <= arr[i]) {
					temp = stack.pop();
					if(stack.empty()) break;
					answer[temp[0]] = stack.peek()[0] + 1;
				}
				stack.add(new Integer[] {i, arr[i]});
			}
		}
		while(!stack.empty()) {
			int temp = stack.pop()[0];
			if(stack.empty()) break;
			answer[temp] = stack.peek()[0] + 1;
		}
		for(int i = 0; i< answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}
}
