import java.util.Scanner;

public class q2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int min = 0;

        int sum = 0;
        for(int i=M; i<N+1; i++) {
            if(isPrime(i)) {
                sum += i;
                if(min == 0) min = i;
            }
        }
        if(sum == 0) System.out.println(-1);
        else System.out.print(sum+"\n"+min);
    }

    public static boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i=2; i<num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}