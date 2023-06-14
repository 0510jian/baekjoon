import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class q17103 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체
        int max = 1000000;
        boolean[] primes = new boolean[max + 2];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for(int i=2; i<Math.sqrt(max); i++) {
            if(primes[i]) {
                for(int j=2*i; j<=max; j+=i)
                    primes[j] = false;
            }
        }



        for(int i=0; i<T; i++) {
            int input = Integer.parseInt(br.readLine());
            int count = 0;

            int j=2;
            while(j < Math.ceil(input/2.0)+1) {
                if(primes[j] && primes[input-j])
                    count++;
                j++;
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}
