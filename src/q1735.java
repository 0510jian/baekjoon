import java.io.*;
import java.util.Scanner;

public class q1735 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[][] inputs = new int[2][2];

        inputs[0][0] = sc.nextInt();
        inputs[0][1] = sc.nextInt();
        inputs[1][0] = sc.nextInt();
        inputs[1][1] = sc.nextInt();

        int denominator = inputs[0][1] * inputs[1][1] / getGcd(inputs[0][1], inputs[1][1]);
        int numerator = inputs[0][0] * (denominator / inputs[0][1]) + inputs[1][0] * (denominator / inputs[1][1]);

        int gcd = getGcd(numerator, denominator);
        System.out.print(numerator/gcd + " " + denominator/gcd);
    }
    public static int getGcd(int a, int b) {
        if(b == 0) return a;
        else return getGcd(b, a%b);
    }
}
