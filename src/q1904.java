import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q1904 {
    static int[] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];

        memo[1] = 1;
        memo[2] = 2;

        bw.write(func(N) + "");
        bw.flush();
    }
    public static int func(int N) {
        if(N == 1 || N == 2) return memo[N];

        if(memo[N] == 0) {
            memo[N] = (func(N-1) + func(N-2)) % 15746;
        }

        return memo[N];
    }
}
