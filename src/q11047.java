import java.util.Scanner;

public class q11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동전의 종류 개수
        int K = sc.nextInt(); // 가치의 합이 되어야 하는 숫자
        int[] coinList = new int[N]; // 동전의 종류
        for(int i=0; i<N; i++) {
            coinList[i] = sc.nextInt();
        }

        int sum = K;
        int coinCount = 0;
        while(true) {
            if(sum == 0) break;
            for(int i=0; i<N; i++) {
                if(sum >= coinList[N-i-1]) {
                    coinCount = coinCount + sum / coinList[N-i-1];
                    sum = sum % coinList[N-i-1];
                }
            }
        }
        System.out.println(coinCount);
    }
}
