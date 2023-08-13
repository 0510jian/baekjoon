import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q28455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] union = new Integer[N];
        for(int i=0; i<N; i++) union[i] = sc.nextInt();
        Arrays.sort(union, Collections.reverseOrder());

        int countLevel = 0;
        int exp = 0;
        int fin = 42;
        if(N < fin) fin = N;

        for(int i=0; i<fin; i++) {
            countLevel += union[i];

            if(union[i] >= 250) exp += 5;
            else if(union[i] >= 200) exp += 4;
            else if(union[i] >= 140) exp += 3;
            else if(union[i] >= 100) exp += 2;
            else if(union[i] >= 60) exp += 1;
        }

        System.out.print(countLevel + " " + exp);
    }
}
