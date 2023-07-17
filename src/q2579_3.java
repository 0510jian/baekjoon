import java.util.Scanner;

public class q2579_3 {
    public static void main(String[] args) {
        // N-1칸을 밟고 N칸을 밟을 경우 + N-2칸은 밟아선 안됨(연속3)
        // n-3 + n-1 + n;
        // memo[i-3] + step[i-1] + step[i]

        // N-2칸을 밟고 N칸을 밟을 경우
        // n-2 + n;
        // memo[i-2] + step[i]

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] step = new int[N];
        for(int i=0; i<N; i++) step[i] = sc.nextInt();

        int[] memo = new int[N];

        try {
            memo[0] = step[0];
            memo[1] = Math.max(step[0] + step[1], step[1]);
            memo[2] = Math.max(step[1] + step[2], step[0] + step[2]);

            for(int i=3; i<N; i++) {
                memo[i] = Math.max(memo[i-3] + step[i-1] + step[i], memo[i-2] + step[i]);
            }
        } catch (Exception e) {}


        System.out.println(memo[N-1]);
    }
}
