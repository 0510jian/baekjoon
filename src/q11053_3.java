import java.util.Scanner;

public class q11053_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];
        arr[0] = 0;
        for(int i=1; i<arr.length; i++) arr[i] = sc.nextInt();

        int[] memo = new int[1001];
        memo[0] = 0;

        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                int max = 0;
                for(int j=arr[i]-1; j>0; j--) {
                    if(memo[j] > max) max = memo[j];
                }
                memo[arr[i]] = Math.max(memo[arr[i]], max+1);
            }
        }

        int max = 0;
        for(int num : arr) {
            if(max < memo[num]) max = memo[num];
        }
        System.out.println(max);
    }
}
