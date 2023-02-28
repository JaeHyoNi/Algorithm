import java.util.*;
public class Main{
    static ArrayList<Integer>[] bj;
    static int N, ans=Integer.MAX_VALUE;
    static int[] val;
    static int bfs(int flag){
        Queue<Integer> wait = new ArrayDeque<>();
        int ret = 0;
        for(int i=0; i<N; i++) {
            if((flag & (1<<i)) > 0){
                wait.add(i); ret |= (1<<i);
                break;
            }
        }
        while(!wait.isEmpty()){
            int tmp = wait.poll();
            for(int i=0; i<bj[tmp].size(); i++){
                if( (flag & (1 << bj[tmp].get(i))) == 0 || (ret & (1<<bj[tmp].get(i))) > 0 ) continue;
                wait.add(bj[tmp].get(i));
                ret |= (1<<bj[tmp].get(i));
            }
        }
        return ret;
    }

    static void check(int visited){
        int notvisited = (~(visited)) & (1<<N)-1;
        int g1 = 0, g2 = 0;
        g1 = bfs(visited); g2 = bfs(notvisited);
        if(visited != g1 || notvisited != g2) return;
        int n1=0, n2=0;
        for(int i=0; i<N; i++){
            if((g1 & (1<<i)) > 0) n1 += val[i];
            else n2 += val[i];
        }
        ans = Math.min(ans, Math.abs(n1-n2));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int tmp;
        bj = new ArrayList[N+1];
        val = new int[N+1];
        for(int i=0; i<N; i++) val[i] = sc.nextInt();
        for(int i=0; i<N; i++) bj[i] = new ArrayList<>();
        for(int i=0; i<N; i++){
            int k = sc.nextInt();
            for(int t=0; t<k; t++) {
                tmp = sc.nextInt();
                bj[i].add(tmp-1); bj[tmp-1].add(i);
            }
        }
        for(int i=1; i<=(1<<N-1)-1; i++) check(i);
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.print(ans);
    }
}
