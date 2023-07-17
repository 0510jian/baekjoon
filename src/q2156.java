import java.util.Scanner;

public class q2156 {
    public static void main(String[] args) {
        // 연속세잔은 못마심
        // 1. 한잔 마시고 ... 연속 두번 : 0 ~ n-3 중 max값 + grape[n-1] + grape[n]
        // 2. 두잔 연속 마시고 ... 한 번 : 0 ~ n-2 중 max값 + grape[n];
        // ... 는 몇번이든 될 수 있음
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] grape = new int[N];
        for(int i=0; i<grape.length; i++) grape[i] = sc.nextInt();

        int[] memo = new int[N];
        try {
            memo[0] = grape[0];
            memo[1] = Math.max(grape[0] + grape[1], grape[1]);
            memo[2] = Math.max(grape[1] + grape[2], memo[0] + grape[2]);

            for(int i=3; i<N; i++) {
                int max1 = 0;
                int max2 = 0;
                for(int j=0; j<i-1; j++) {
                    if(max1 < memo[j] && j != i-2) max1 = memo[j];
                    if(max2 < memo[j]) max2 = memo[j];
                }
                memo[i] = Math.max(max1 + grape[i-1] + grape[i] , max2 + grape[i]);
            }
        } catch (Exception e) {}

        int max = 0;
        for(int g : memo) {
            if(max < g) max = g;
        }
        System.out.println(max);
    }
}
