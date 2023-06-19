import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class q1010 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] input = br.readLine().split(" ");
            int K = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);

            bw.write(factorial(N).divide(factorial(K).multiply(factorial(N - K)))+"\n");
        }
        bw.flush();
    }
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(n);

        if(n == 0) return BigInteger.valueOf(1);
        for(int i=n-1; i>0; i--){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
