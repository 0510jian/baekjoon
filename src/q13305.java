import java.math.BigInteger;
import java.util.Scanner;

public class q13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] road = new long[N-1];
        long[] city = new long[N];

        for(int i=0; i<road.length; i++) road[i] = sc.nextInt();
        for(int i=0; i<city.length; i++) city[i] = sc.nextInt();

        BigInteger[] memo = new BigInteger[road.length];
        memo[0] = BigInteger.valueOf(city[0] * road[0]);
        long min = city[0];

        for(int i=1; i<road.length; i++) {
            if(city[i] < min) min = city[i];
            memo[i] = memo[i-1].add(BigInteger.valueOf(min * road[i]));
        }

        System.out.println(memo[road.length-1]);
    }
}
