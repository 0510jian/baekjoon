import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();

        ArrayList<Integer> inputs = new ArrayList<>();

        while(true) {
            if(N < B) {
                inputs.add(N);
                break;
            }
            inputs.add(N%B);
            N /= B;
        }

        Collections.reverse(inputs);

        for(int input : inputs) {
            if(input < 10) System.out.print(input);
            else System.out.print((char)('A'-10+input));
        }
    }
}
