import java.util.ArrayList;
import java.util.Scanner;

public class q2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i < 1000000; i++) {
            // 자리수별로 분할하여 저장
            ArrayList<Integer> numbers = new ArrayList<>();
            int number = i;
            while (true) {
                if (number < 10) {
                    numbers.add(number);
                    break;
                }
                numbers.add(number % 10);
                number /= 10;
            }

            // 분해합과 M 구하기
            int sum = 0; // 분해합
            int M = 0; // M(N의 생성자)
            for (int j = 0; j < numbers.size(); j++) {
                sum = (int) (sum + numbers.get(j) + (numbers.get(j) * Math.pow(10, j)));
                M = (int) (M + (numbers.get(j) * Math.pow(10, j)));
            }
            if (sum == N) { // 최소 생성자 발견 시 출력 후 return
                System.out.print(M);
                return;
            }
        }
        System.out.print(0); // 생성자 없을 시 0 출력
    }
}