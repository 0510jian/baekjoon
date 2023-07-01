import java.util.Arrays;
import java.util.Scanner;

public class q4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String inputs = sc.nextLine();
            if(inputs.equals("0 0 0")) break;

            String[] input = inputs.split(" ");
            int[] value = new int[3];
            for(int i=0; i<value.length; i++) {
                value[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(value);

            if(Math.pow(value[0], 2) + Math.pow(value[1], 2) == Math.pow(value[2], 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
