import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> inputs = new ArrayList<>();

        for(int i=0; i<5; i++)
            inputs.add(sc.nextInt());

        Collections.sort(inputs);

        System.out.println((inputs.get(0)+inputs.get(1)+inputs.get(2)+inputs.get(3)+inputs.get(4))/5);
        System.out.println(inputs.get(2));
    }
}
