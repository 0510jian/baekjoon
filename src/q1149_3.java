import java.util.Scanner;

public class q1149_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] house = new int[N+1][3];

        house[0][0] = 0;
        house[0][1] = 0;
        house[0][2] = 0;

        for(int i=1; i<N+1; i++) {
            int[] cost = new int[3];
            cost[0] = sc.nextInt();
            cost[1] = sc.nextInt();
            cost[2] = sc.nextInt();

            house[i][0] = Math.min(house[i-1][1], house[i-1][2]) + cost[0];
            house[i][1] = Math.min(house[i-1][0], house[i-1][2]) + cost[1];
            house[i][2] = Math.min(house[i-1][0], house[i-1][1]) + cost[2];
        }

        System.out.println(Math.min(house[N][0], Math.min(house[N][1], house[N][2])));
    }
}
