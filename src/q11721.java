import java.util.Scanner;

public class q11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split("");

        for(int i=0; i<split.length; i++) {
            System.out.print(split[i]);
            if(i % 10 == 9) System.out.println();
        }
    }
}
