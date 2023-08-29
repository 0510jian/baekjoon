import java.util.Scanner;

public class q1032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();

        for(int i=1; i<N; i++) {
            String temp = sc.nextLine();

            String newInput = "";

            for(int j=0; j<input.length(); j++) {
                if(input.charAt(j) == temp.charAt(j)) newInput += String.valueOf(input.charAt(j));
                else newInput += "?";
            }

            input = newInput;
        }

        System.out.print(input);
    }
}
