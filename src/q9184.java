import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class q9184 {
    static HashMap<String, Integer> memo = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();

            if(input.equals("-1 -1 -1")) break;

            String[] inputs = input.split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c) + "\n");
        }
        bw.flush();
    }
    public static int w(int a, int b, int c) {
        if(a<=0 || b<=0 || c<=0) return 1;
        else if(a>20 || b>20 || c>20) return w(20, 20, 20);

        if(memo.containsKey(a + " " + b + " " + c)) {
            return memo.get(a + " " + b + " " + c);
        }

        if(a<b && b<c) {
            memo.put(a + " " + b + " " + c, w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c));
        } else {
            memo.put(a + " " + b + " " + c, w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1));
        }
        return memo.get(a + " " + b + " " + c);
    }
}
