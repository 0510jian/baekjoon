import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class q1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N+1];

        try {
            memo[1] = 0;
            memo[2] = 1;
            memo[3] = 1;

            for(int i=4; i<memo.length; i++) {
                ArrayList<Integer> result = new ArrayList<>();
                if(i % 3 == 0) result.add(1 + memo[i/3]);
                if(i % 2 == 0) result.add(1 + memo[i/2]);
                result.add(1 + memo[i-1]);

                memo[i] = Collections.min(result);
            }
        } catch (Exception e) {}

        bw.write(memo[N]+"");
        bw.flush();
    }
}
