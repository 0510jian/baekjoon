import java.io.*;

public class q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        for(int i=Integer.parseInt(inputs[0]); i<Integer.parseInt(inputs[1])+1; i++) {
            if(isPrime(i) && i != 1) bw.write(i + "\n");
        }
        bw. flush();
    }

    public static boolean isPrime(int num) {
        for(int i=2; i<Math.sqrt(num)+1; i++) {
            if(num != i && num % i == 0) return false;
        }
        return true;
    }
}
