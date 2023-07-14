import java.util.Scanner;

public class q9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int N = sc.nextInt();

            long[] memo = new long[101];
            memo[1] = memo[2] = memo[3] = 1;
            memo[4] = memo[5] = 2;

            for(int j=5; j<N+1; j++) {
                memo[j] = memo[j-1] + memo[j-5];
            }

            System.out.println(memo[N]);
        }
    }
}
