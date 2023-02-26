import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean flag = false;
    static void dfs(int K, int dep){
        if(dep == 5 || flag) {flag = true; return;}
        int siz = arr[K].size();
        for(int i=0; i<siz; i++){
            if(!visited[arr[K].get(i)]){
                visited[arr[K].get(i)] = true;
                dfs(arr[K].get(i), dep+1);
                if(flag) return;
                visited[arr[K].get(i)] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int f, t, N=Integer.parseInt(st.nextToken()), M= Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];
        for(int i=0; i<N; i++) arr[i] = new ArrayList<Integer>();
        visited = new boolean[N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            f=Integer.parseInt(st.nextToken()); t=Integer.parseInt(st.nextToken());
            arr[f].add(t); arr[t].add(f);
        }
        for(int k=0; k<N; k++) {
            visited[k] = true;
            dfs(k, 1);
            visited[k] = false;
        }
        if(flag) System.out.print(1);
        else System.out.print(0);
    }
}
