import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q11866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        boolean[] queue = new boolean[Integer.parseInt(NK[0])];

        int index = 0;
        int count = 0;
        String result = "";

        bw.write("<");

        while(true) {
            int countK= 0;
            if(count == N) break;

            while(countK < K) {
                if(!queue[index%N]) {
                    countK++;
                }
                index++;
            }
            index--;
            count++;
            queue[index%N] = true;
            result += (index%N + 1 + ", ");
        }
        bw.write(result.substring(0, result.length()-2) + ">");
        bw.flush();
    }
}
