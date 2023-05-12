import java.util.ArrayList;
import java.util.Scanner;

public class q2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> cards = new ArrayList<>();

        for(int i=0; i<N; i++) {
            cards.add(sc.nextInt());
        }

        int max = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    if(i != j && j != k && i != k) {
                        int sum = cards.get(i) + cards.get(j) + cards.get(k);
                        if(sum > max && sum <= M) max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
