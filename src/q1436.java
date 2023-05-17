import java.util.Scanner;

public class q1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int number = 665;

        while(true) {
            if(N == 0) {
                System.out.print(number);
                return;
            }

            number += 1;
            if(String.valueOf(number).contains("666")) N -= 1;
        }
    }
}
