import java.util.Scanner;

public class q8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] scores = new int[N];

        for(int i=0; i<N; i++) {
            int score = 0;
            int count = 0;
            String[] OX = sc.nextLine().split("");

            for(int j=0; j< OX.length; j++) {
                if(OX[j].equals("O")) {
                    score += ++count;
                } else {
                    count = 0;
                }
            }
            scores[i] = score;
        }

        for(int i=0; i<N; i++) {
            System.out.println(scores[i]);
        }
    }
}
