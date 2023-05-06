import java.util.Scanner;

public class q2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] inputs = new int[T];
        int[][] change = new int[T][4];

        for(int i=0; i<T; i++) {
            inputs[i] = sc.nextInt();

            change[i][0] = inputs[i] / 25;
            inputs[i] %= 25;

            change[i][1] = inputs[i] / 10;
            inputs[i] %= 10;

            change[i][2] = inputs[i] / 5;
            inputs[i] %= 5;

            change[i][3] = inputs[i];
        }

        for(int i=0; i<T; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(change[i][j] + " ");
            }
            System.out.println();
        }
    }
}