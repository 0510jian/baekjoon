import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class q15740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(tk.nextToken());
        BigInteger B = new BigInteger(tk.nextToken());

        System.out.print(A.add(B));
    }
}
