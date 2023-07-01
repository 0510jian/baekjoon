import java.util.Scanner;

public class q2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        System.out.println(Math.abs(Long.parseLong(input[0]) - Long.parseLong(input[1])));
    }
}
