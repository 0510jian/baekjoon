import java.util.Scanner;

public class q1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputs = sc.nextLine().trim().split(" ");

        if(inputs.length == 1 && inputs[0].equals(""))
            System.out.println(0);
        else
            System.out.println(inputs.length);
    }
}
