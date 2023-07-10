import java.util.Scanner;

public class q1966 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] input = new int[sumAll(N)];

            int front = 0;
            int rear = N-1;

            for(int j=front; j<rear+1; j++) {
                input[j] = sc.nextInt();
            }

            int countPrint = 0;
            int checkIndex = M;
            while(true) {
                boolean isBreak = false;
                for(int j=front+1; j<rear+1; j++) {
                    // 뒤에 큰 수가 있으면
                    if(input[front] < input[j]) {
                        // 체크해야 하는 인덱스일 경우
                        if(checkIndex == front) {
                            checkIndex = checkIndex + (rear-front+1);
                        }
                        input[rear+1] = input[front];
                        front++;
                        rear++;
                        isBreak = true;
                        break;
                    }
                }
                // 뒤에 큰 수가 없으면
                if(front==rear || !isBreak) {
                    countPrint++;
                    // 체크해야 하는 인덱스일 경우
                    if(checkIndex == front) {
                        System.out.println(countPrint);
                        break;
                    }
                    front++;
                }
            }
        }
    }

    public static int sumAll(int n) {
        int sum = 0;
        for(int i=1; i<n+1; i++)
            sum += i;
        return sum;
    }
}
