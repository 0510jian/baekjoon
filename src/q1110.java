import java.util.Scanner;

public class q1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();
        int start = Integer.parseInt(N);

        int count = 0;
        while(true) {
            count++;

            String[] split = N.split("");

            int sum = 0;
            for(int i=0; i<split.length; i++) sum += Integer.parseInt(split[i]);

            N = String.valueOf(Integer.parseInt(N) % 10) + String.valueOf(sum % 10);
            if(Integer.parseInt(N) == start) {
                System.out.print(count);
                return;
            }
        }
    }
}
