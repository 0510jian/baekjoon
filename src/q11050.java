import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q11050 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        bw.write(factorial(N) / (factorial(K)*factorial(N - K))+"");
        bw.flush();
    }

    public static int factorial(int n) {
        if(n==0) return 1;
        for(int i=n-1; i>0; i--)
            n *= i;
        return n;
    }
}
