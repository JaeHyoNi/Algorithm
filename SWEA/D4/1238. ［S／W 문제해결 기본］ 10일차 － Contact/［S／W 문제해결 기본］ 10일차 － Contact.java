import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++){
            int s, e, N=sc.nextInt(), start = sc.nextInt();
            boolean[] visited = new boolean[101];
            ArrayList<Integer> arr[] = new ArrayList[101];
            for(int i=0; i<101; i++) arr[i] = new ArrayList<Integer>();
            for(int i=0; i<N/2; i++) arr[sc.nextInt()].add(sc.nextInt());
            Queue<Integer> wait = new ArrayDeque<>();
            wait.add(start);
            visited[start] = true;
            int max = -1;
            while(!wait.isEmpty()){
                int next, siz = wait.size();
                max = -1;
                for(int i=0; i<siz; i++){
                    next = wait.poll();
                    max = Math.max(next, max);
                    for(Integer K: arr[next]){
                        if(visited[K]) continue;
                        wait.add(K);
                        visited[K] = true;
                    }
                }
            }
            System.out.printf("#%d %d\n",tc, max);
        }
    }
}
