import java.util.Arrays;
import java.util.Scanner;

public class q11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] person = new int[N];
        for(int i=0; i<N; i++) person[i] = sc.nextInt();
        Arrays.sort(person);

        int[] memo = new int[N];
        int totalTime = 0;
        for(int i=0; i<N; i++) {
            if(i==0) memo[0] = person[i];
            else memo[i] = memo[i-1] + person[i];
            totalTime += memo[i];
        }
        System.out.println(totalTime);
    }
}
