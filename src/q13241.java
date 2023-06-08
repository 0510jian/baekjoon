import java.io.*;

public class q13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        bw.write(A * B / getGcd(A,B) + "\n");
        bw.flush();
    }
    public static long getGcd(long a, long b) {
        if(b == 0) return a;
        else return getGcd(b, a%b);
    }
}
