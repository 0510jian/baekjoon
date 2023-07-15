import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n*n];

        memo[0] = sc.nextInt();

        for(int i=1; i<n; i++) {
            for(int j=0; j<i+1; j++) {
                try {
                    int temp = sc.nextInt();

                    if(j==0) { // 맨 왼쪽
                        memo[i*n + j] = memo[(i-1)*n + j] + temp;
                    } else if(j==i) { // 맨 오른쪽
                        memo[i*n + j] = memo[(i-1)*n + (j-1)] + temp;
                    } else{
                        // 좌우 둘 중 큰 것 선택
                        memo[i*n + j] = Math.max(memo[(i-1)*n + (j-1)], memo[(i-1)*n + (j)]) + temp;
                    }
                } catch (Exception e) {}
            }
        }

        ArrayList<Integer> sums = new ArrayList<>();
        for(int i=n*(n-1); i<n*n; i++) {
            sums.add(memo[i]);
        }
        System.out.println(Collections.max(sums));
    }
}
