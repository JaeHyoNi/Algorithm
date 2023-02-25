import java.util.Scanner;

public class Main {
    static char[][] arr;
    static void draw(int x1, int y1, int x2, int y2){
        if(x2-x1 == 2 && y2 - y1 == 2){
            for(int i = x1; i<= x2; i++){for(int j = y1; j <= y2; j++) arr[i][j] = '*';}
            arr[x1+1][y1+1] = ' ';
            return;
        }
        int off = (x2+1-x1)/3  ;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) continue;
                draw(x1+off*i, y1+off*j, x1+off*(i+1)-1, y1+off*(j+1)-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int N = sc.nextInt();
        arr= new char[N][N];
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) arr[i][j] = ' ';
        draw(0, 0, N-1, N-1);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ans.append(arr[i][j]);
            }ans.append("\n");
        }
        System.out.print(ans);
    }
}