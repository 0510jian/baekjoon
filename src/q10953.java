import java.util.Scanner;

public class q10953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for(int i=0; i<T; i++) {
            String[] input = sc.nextLine().split(",");
            System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
        }
    }
}
