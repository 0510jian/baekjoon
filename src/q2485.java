import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q2485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> inputs = new ArrayList<>(); // 입력 리스트
        ArrayList<Integer> subs = new ArrayList<>(); // 각 수의 차 리스트

        for(int i=0; i<N; i++)
            inputs.add(sc.nextInt());
        Collections.sort(inputs);

        for(int i=1; i<N; i++)
            subs.add(inputs.get(i) - inputs.get(i-1));
        Collections.sort(subs);

        int gcd = getGcd(subs.get(0), subs.get(1));
        for(int i=2; i< subs.size(); i++)
            gcd = getGcd(gcd, subs.get(i));

        System.out.print(((inputs.get(inputs.size()-1) - inputs.get(0)) / gcd) + 1 - inputs.size());
    }
    public static int getGcd(int a, int b) {
        if(b == 0) return a;
        else return getGcd(b, a%b);
    }
}
