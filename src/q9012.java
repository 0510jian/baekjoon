import java.util.Scanner;

public class q9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());


        for(int i=0; i<T; i++) {
            int count = 0;
            String[] inputs = sc.nextLine().split("");
            for(String input : inputs) {
                if(input.equals("(")) count++;
                else count--;

                if(count < 0) break;
            }
            if(count == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
