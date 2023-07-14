import java.util.Scanner;

public class q1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];
        int[] memo = new int[n+1];
        for(int i=0; i<array.length; i++) {
            array[i] = sc.nextInt();
        }

        // 다음 걸 더했을 때 현재보다 수가 작아지면 안됨
        int max = memo[0] = array[0];
        for(int i=1; i<array.length; i++) {
            int temp;

            // array[i]가 양수인 경우
            if(array[i] > 0) {
                if(memo[i-1] > 0) temp = memo[i-1] + array[i];
                else temp = array[i];

                if(max < temp) max = temp;
            }
            // array[i]가 음수인 경우
            else {
                // 더한 값이 양수일 경우
                if(memo[i-1] + array[i] > 0) {
                    temp = memo[i-1] + array[i];
                    if(max < temp) max = temp;
                }
                // 더한 값이 음수인 경우
                else {
                    if(memo[i-1] <= array[i]) {
                        temp = array[i];
                        if(max < array[i]) max = array[i];
                    }
                    else temp = 0;
                }
            }
            memo[i] = temp;
        }
        System.out.println(max);
    }
}
