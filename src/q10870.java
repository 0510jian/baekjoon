import java.util.Scanner;

public class q10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(F(n));
    }
    public static int F(int n) {
        if(n == 0) return 0;
        else if(n==1) return 1;
        else {
            return F(n-2) + F(n-1);
        }
    }
}
