import java.util.Scanner;

public class q1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        if(x > w/2) x = w-x;
        if(y > h/2) y = h-y;

        System.out.print(Math.min(x, y));
    }
}