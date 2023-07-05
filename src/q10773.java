import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class q10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> stack = new ArrayList<>();

        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                stack.remove(stack.size()-1);
            } else {
                stack.add(input);
            }
        }

        int sum = 0;
        for(int i=0; i<stack.size(); i++) {
            sum += stack.get(i);
        }

        bw.write(sum+"");
        bw.flush();
    }
}
