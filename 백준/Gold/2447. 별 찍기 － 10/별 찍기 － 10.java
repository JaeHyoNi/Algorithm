import java.util.*;

public class Main{
    static char[][] arr;
    static void draw(int x, int y, int siz){
        if(siz == 3){
            arr[x][y]=arr[x][y+1]=arr[x][y+2]=arr[x+1][y]=arr[x+1][y+2]=arr[x+2][y]=arr[x+2][y+1]=arr[x+2][y+2]='*';
            return;
        }
        siz/=3;
        for(int i=0; i<3; i++){for(int j=0; j<3; j++){if(i==1 && j==1) continue; draw(x+siz*i, y+siz*j, siz);}}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        arr= new char[N][N];
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) arr[i][j] = ' ';
        draw(0, 0, N);
        for(int i=0; i<N; i++){for(int j=0; j<N; j++){sb.append(arr[i][j]);}sb.append('\n');}
        System.out.print(sb);
    }
}
