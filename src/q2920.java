import java.util.*;

public class q2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = new String[8];

        for(int i=0; i<8; i++) {
            inputs[i] = String.valueOf(sc.nextInt());
        }
        String input = String.join("", inputs);

        if(input.equals("12345678")) System.out.println("ascending");
        else if(input.equals("87654321")) System.out.println("descending");
        else System.out.println("mixed");
    }
}
