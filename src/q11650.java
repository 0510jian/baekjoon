import java.util.Arrays;
import java.util.Scanner;

public class q11650 {
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
            if(o1[0] == o2[0]) // 첫번째 값이 같을 때, 두번째 값 비교
                return Integer.compare(o1[1], o2[1]);
            else // 첫번째 값 비교
                return Integer.compare(o1[0], o2[0]);
        });

        for(int i=0; i<N; i++)
            System.out.println(inputs[i][0] + " " +inputs[i][1]);
    }
}
