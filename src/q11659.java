import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N, M 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 수 입력
        int[] list = new int[N];
        int[] memo = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<list.length; i++) {
            list[i] = Integer.parseInt(input[i]);
            if(i == 0) memo[i] = list[i];
            else memo[i] = memo[i-1] + list[i];
        }

        // 각 슬라이싱 번호 입력
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;

            if(s == 0) bw.write(memo[e] + "\n");
            else bw.write( memo[e] - memo[s-1] + "\n");
        }
        bw.flush();
    }
}
