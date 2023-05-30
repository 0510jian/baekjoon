import java.util.Scanner;

public class q2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0; // 방 개수
        int i = 0;
        int N = sc.nextInt();

        while(true) {
            if(i == 0) N -= 1;
            else N -= (6*i);

            count++;
            i++;

            if(N <= 0) break;
        }
        System.out.print(count);
    }
}
