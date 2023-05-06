import java.util.Scanner;

public class q2903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 2;

        for(int i=0; i<N; i++)
            result += Math.pow(2, i);

        System.out.println(result*result);
    }
}

//    [2*2]  --(2^0 증가)-->  [3*3]  --(2^1 증가)-->  [5*5]  --(2^2 증가)-->  [9*9]