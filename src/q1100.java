import java.util.Scanner;

public class q1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = 8;
        boolean[][] board = new boolean[N][N];

        int count = 0;
        for(int i=0; i<N; i++) {
            String[] split = sc.nextLine().split("");
            for(int j=0; j<N; j++) {
                if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0)) board[i][j] = true;
                if(board[i][j] && split[j].equals("F")) count++;
            }
        }
        System.out.print(count);
    }
}
