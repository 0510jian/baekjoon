import java.io.*;
import java.util.ArrayList;

public class q4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Long> inputs = new ArrayList<>();

        for(int i=0; i<T; i++)
            inputs.add(Long.parseLong(br.readLine()));

        for(int i=0; i<T; i++) {
            long result = inputs.get(i);
            if(result == 0 || result == 1) result = 2;
            while(true) {
                if(isPrime(result)) break;
                result++;
            }
            bw.write(result+"\n");
        }
        bw.flush();
    }
    public static boolean isPrime(long n) {
        for(int i = 2; i<Math.sqrt(n)+1; i++)
            if(i != n && n % i == 0) return false;
        return true;
    }
}
