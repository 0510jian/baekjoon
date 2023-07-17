import java.util.Scanner;

public class q11054 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];
        arr[0] = 0;
        for(int i=1; i<arr.length; i++) arr[i] = sc.nextInt();

        int max = 0;

        for(int i=1; i<arr.length; i++) {
            int left = 0, right = 0;

            if(i > 1) {
                int[] leftArr = new int[i];
                leftArr[0] = 0;
                for(int j=1; j<i; j++) leftArr[j] = arr[j];
                left = LIS(leftArr, arr[i]);
            }
            if(i < arr.length - 1) {
                int[] rightArr = new int[arr.length-i];
                rightArr[0] = 0;
                for(int j=1; j<rightArr.length; j++) rightArr[j] = arr[j+i];
                right = LDS(rightArr, arr[i]);
            }

            if(max < left + right + 1) max = left + right + 1;
        }

        System.out.println(max);
    }

    public static int LIS(int[] arr, int standard) {
        int[] memo = new int[1001];
        memo[0] = 0;

        for(int i=1; i<arr.length; i++) {
            // 기준이 되는 standard보다 작은 수여야 함
            if(arr[i] >= standard) continue;

            if(arr[i-1] != arr[i]) {
                int max = 0;
                for(int j=arr[i]-1; j>0; j--) {
                    if(memo[j] > max) max = memo[j];
                }
                memo[arr[i]] = Math.max(memo[arr[i]], max+1);
            }
        }

        int max = 0;
        for(int num : memo) {
            if(max < num) max = num;
        }
        return max;
    }

    public static int LDS(int[] arr, int standard) {
        int[] memo = new int[1002];
        memo[0] = 0;

        for(int i=1; i<arr.length; i++) {
            // 기준이 되는 standard보다 작은 수여야 함
            if(arr[i] >= standard) continue;

            if(arr[i-1] != arr[i]) {
                int max = 0;
                for(int j=arr[i]+1; j<standard; j++) {
                    if(memo[j] > max) max = memo[j];
                }
                memo[arr[i]] = Math.max(memo[arr[i]], max+1);
            }
        }

        int max = 0;
        for(int num : memo) {
            if(max < num) max = num;
        }
        return max;
    }
}
