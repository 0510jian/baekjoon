import java.util.Scanner;

public class q2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int gcd = getGcd(A, B);
        System.out.println(gcd);
        System.out.println(A*B/gcd);
    }
    public static int getGcd(int a, int b) {
        if(b == 0) return a;
        else return getGcd(b, a%b);
    }
}
