import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q1904 {
    static int[] memo;
    static int num = 15746;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];

        memo[1] = 1;
        memo[2] = 2;

        for(int i=3; i< memo.length; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % num;
        }
        bw.write(memo[N] + "");
        bw.flush();
    }
}
