import java.util.Scanner;

public class q2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            // 앞 공백
            for(int j=0; j<i; j++) System.out.print(" ");
            // 뒷 별
            for(int j=0; j<N*2 - i*2 - 1; j++) System.out.print("*");
            // 개행
            System.out.println();
        }
        for(int i=1; i<N; i++) {
            // 앞 공백
            for(int j=i; j<N-1; j++) System.out.print(" ");
            // 뒷 별
            for(int j=0; j<i*2+1; j++) System.out.print("*");
            // 개행
            System.out.println();
        }
    }
}
