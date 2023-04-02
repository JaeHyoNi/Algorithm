import java.util.*;
class p{ int a,b; public p(int a, int b) {this.a = a;this.b = b;}}
public class Main{
    static int arr[][]=new int[9][9], r[]=new int[9], c[]=new int[9], m[]=new int[9];
    static ArrayList<p> n = new ArrayList();
    static void sol(int k){
        if(k == n.size()) {
            for(int[] i: arr){
                for(int j:i) System.out.print(j+" ");
                System.out.println();
            }
            System.exit(0);
        }
        int x = n.get(k).a, y=n.get(k).b;
        for(int i=1; i<10; i++){
            int t = (x/3)*3+y/3;
            if((r[x] & (1 << i)) == 0 && (c[y] & (1 << i)) == 0 && (m[t] & (1 << i)) == 0) {
                int a = r[x], b = c[y], n = m[(x / 3) * 3 + y / 3];
                r[x] |= (1 << i); c[y] |= (1 << i); m[t] |= (1 << i);
                arr[x][y] = i;
                sol(k + 1);
                arr[x][y] = 0;
                r[x] = a; c[y] = b; m[t] = n;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9; i++) for(int j=0; j<9; j++) {
            arr[i][j]=sc.nextInt();
            if(arr[i][j] != 0){
                r[i] |= (1 << arr[i][j]);
                c[j] |= (1 << arr[i][j]);
                m[3*(i/3) + (j/3)] |= (1 << arr[i][j]);
            }
            else n.add(new p(i, j));
        }
        sol(0);
    }
}