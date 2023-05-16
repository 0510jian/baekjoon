import java.util.Scanner;

public class q2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<5001; i+=3) {
            for(int j=0; j<5001; j+=5) {
                if(i + j == N){
                    System.out.println((i/3)+(j/5));
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}