import java.util.Scanner;

public class q1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        // 1. N번째 줄 찾기 = 최종 i값
        int N = 0;
        int i = 1;

        while(true) {
            N += i;
            if(N >= X) {
                N -= i;
                break;
            }
            i++;
        }

        // 2. i의 홀짝 구하기
        X -= N;
        if(i%2==0) { // 짝수일 경우 분자순
            System.out.print(X + "/" + (i+1-X));
        } else { // 홀수일 경우 분모순
            System.out.print((i+1-X) + "/" + X);
        }
    }
}