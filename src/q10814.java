import java.util.*;

public class q10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] inputs = new String[N][2];

        for(int i=0; i<N; i++) {
            String[] input = sc.nextLine().split(" ");
            inputs[i][0] = input[0];
            inputs[i][1] = input[1];
        }

        Arrays.sort(inputs, Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        for (String[] input2 : inputs)
            System.out.println(input2[0] + " " + input2[1]);
    }
}
