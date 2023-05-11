import java.util.Scanner;

public class q24313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        for(int i=n0; i<101; i++) {
            if(!((a1*i + a0) <= (c * i))) {
                System.out.println(0);
                break;
            }
            if(i==100) System.out.print(1);
        }
    }
}