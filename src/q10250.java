import java.util.Scanner;

public class q10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int floor = sc.nextInt();
            int number = sc.nextInt();
            int person = sc.nextInt();

            if(person % floor == 0) {
                System.out.print(floor);
                System.out.printf("%02d\n", person / floor);
            } else {
                System.out.print(person % floor);
                System.out.printf("%02d\n", person / floor + 1);
            }
        }
    }
}
