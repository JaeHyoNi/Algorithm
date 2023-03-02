import java.util.*;
public class Main {
    static class shark implements Comparable<shark> {
        int x, y, s, d, val;
        public shark(int x, int y, int s, int d, int val){this.x=x; this.y=y; this.s=s; this.d=d; this.val=val;}
        @Override
        public int compareTo(shark o) {return o.val-this.val;}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R=sc.nextInt(), C=sc.nextInt(), M=sc.nextInt();
        int[] dx = {0, 1, 1, 0, 0}, dy = {0, 0, 0, 1, 1};
        shark[] sharks = new shark[M];
        for(int i=0; i<M; i++)  sharks[i] = new shark(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), sc.nextInt(), sc.nextInt());
        Arrays.sort(sharks);
        Queue<shark> wait = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        int fx=99999, fy = 0, pre = 0, tx, ans = 0, nx, ny, next, tmppre;
        for(int i=0; i<M; i++){
            wait.add(sharks[i]);
            if(sharks[i].y == fy && sharks[i].x < fx) {fx=sharks[i].x; fy=sharks[i].y; pre = sharks[i].val;}
        }
        for(int t=1; t<=C; t++){
            int siz = wait.size();
            visited.clear();
            tx = 101; tmppre = 0;
            for(int i=0; i<siz; i++){
                shark ns = wait.poll();
                if(ns.val == pre) { ans += pre; continue;}
                if(R!=1) nx = ns.s % (R*2-2) * dx[ns.d];
                else nx = 0;
                while(nx != 0){
                    if(ns.d == 1){if(ns.x==0){ns.d = 2; continue;} ns.x--; nx--;}
                    else{if(ns.x == R-1){ns.d = 1; continue;} ns.x++;nx--;}
                }
                if(C!=1) ny = ns.s % (C*2-2) * dy[ns.d];
                else ny=0;
                while(ny != 0){
                    if(ns.d == 4){if(ns.y==0){ns.d = 3; continue;} ns.y--; ny--;}
                    else{if(ns.y == C-1){ns.d = 4; continue;} ns.y++; ny--;}
                }
                next = ns.x*C + ns.y;
                if(visited.contains(next)) continue;
                visited.add(next);
                wait.add(ns);
                if(ns.y == t && ns.x < tx) {tmppre = ns.val; tx = ns.x;}
            }
            pre = tmppre;
        }
        System.out.println(ans);
    }
}
