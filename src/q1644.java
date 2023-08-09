import java.io.*;
import java.util.ArrayList;

public class q1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i<=N; i++) {
            if(isPrime(i)) list.add(i);
        }

        for(int i=0; i<list.size(); i++) {
            int temp = list.get(i);
            if(temp == N) {
                count++;
                continue;
            }

            for(int j=i+1; j<list.size(); j++) {
                temp += list.get(j);
                if(temp == N) {
                    count++;
                    break;
                }
                if(temp > N) break;
            }
        }
        bw.write(count+"");
        bw.flush();
    }

    public static boolean isPrime(int n) {
        for(int i=2; i<Math.sqrt(n)+1; i++) {
            if(n != i && n % i == 0) return false;
        }
        return true;
    }
}
