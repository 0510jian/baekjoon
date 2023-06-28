import java.util.Scanner;

public class q1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String[] input = sc.nextLine().split("");
            StringBuilder inputReverse = new StringBuilder(String.join("",input.clone())).reverse();

            if(inputReverse.toString().equals("0")) break;
            else if(inputReverse.toString().equals(String.join("", input))) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
