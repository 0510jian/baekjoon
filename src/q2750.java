import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> inputs = new ArrayList<>();

        for(int i=0; i<N; i++)
            inputs.add(sc.nextInt());

        Collections.sort(inputs);

        for (int input: inputs)
            System.out.println(input);
    }
}
