import java.util.HashMap;
import java.util.Scanner;

public class q2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        int number = 1;
        for(int i=0; i<3; i++) {
            number *= sc.nextInt();
        }
        String[] inputs = String.valueOf(number).split("");

        for(int j=0; j< inputs.length; j++) {
            if(map.containsKey(inputs[j])) map.put(inputs[j], map.get(inputs[j])+1);
            else map.put(inputs[j], 1);
        }

        for(int i=0; i<10; i++) {
            if(map.containsKey(String.valueOf(i))) System.out.println(map.get(String.valueOf(i)));
            else System.out.println(0);
        }
    }
}
