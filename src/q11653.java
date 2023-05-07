import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> values = new ArrayList<>();

        if(N == 1) return;

        while(!isPrime(N)) {
            for(int i=2; i<N; i++) {
                if(N%i==0) {
                    values.add(i);
                    break;
                }
            }
            N /= values.get(values.size()-1);
        }
        values.add(N);

        Collections.sort(values);
        for (int value: values) {
            System.out.println(value);
        }
    }

    public static boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i=2; i<num; i++)
            if(num%i==0) return false;
        return true;
    }
}