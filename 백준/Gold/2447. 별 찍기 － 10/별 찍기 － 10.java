import java.util.*;

public class Main {
    static char[][] arr;
    static void draw(int x1, int y1, int siz){
        if(siz == 3){
            for(int i = x1; i< x1+siz; i++) for(int j = y1; j < y1+siz; j++) arr[i][j] = '*';
            arr[x1+1][y1+1] = ' ';
            return;
        }
        siz/=3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) continue;
                draw(x1+siz*i, y1+siz*j, siz);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        arr= new char[N][N];
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) arr[i][j] = ' ';
        draw(0, 0, N);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(arr[i][j]);
            }sb.append('\n');
        }
        System.out.println(sb);
    }
}
