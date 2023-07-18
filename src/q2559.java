import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] list = new int[N];
        int[] memo = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
            if(i==0) memo[i] = list[i];
            else memo[i] = memo[i-1] + list[i];
        }

        ArrayList<Integer> temperatures = new ArrayList<>();
        for(int i=0; i<N-K+1; i++) {
            if(i==0) temperatures.add(memo[i+(K-1)]);
            else temperatures.add(memo[i+(K-1)] - memo[i-1]);
        }
        System.out.println(Collections.max(temperatures));
    }
}