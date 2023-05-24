import java.util.Arrays;
import java.util.Scanner;

public class q11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        int[][] inputs = new int[N][2];

        for(int i=0; i<N; i++) {
            String[] temp = sc.nextLine().split("\\s");

            inputs[i][0] = Integer.parseInt(temp[0]);
            inputs[i][1] = Integer.parseInt(temp[1]);
        }

        Arrays.sort(inputs, (o1, o2) -> {
            if(o1[1] == o2[1])
                return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        for(int i=0; i<N; i++)
            System.out.println(inputs[i][0] + " " +inputs[i][1]);
    }
}
