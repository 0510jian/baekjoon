import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class q4948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> listN = new ArrayList<>();

        while(true) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) break;
            listN.add(input);
        }

        for(int i=0; i<listN.size(); i++) {

            int count = 0;
            for(int j=listN.get(i) + 1; j<2 * listN.get(i) + 1; j++) {
                if(isPrime(j)) count++;

            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
    public static boolean isPrime(int n) {
        for(int i=2; i<Math.sqrt(n)+1; i++) {
            if(n == 1 || (n != i && n % i == 0)) return false;
        }
        return true;
    }
}
