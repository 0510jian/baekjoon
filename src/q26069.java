import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class q26069 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> list = new HashSet<String>();
        list.add("ChongChong");

        int count = 1;
        for(int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            if(list.contains(inputs[0]) && !list.contains(inputs[1])) {
                count++;
                list.add(inputs[1]);
            } else if(!list.contains(inputs[0]) && list.contains(inputs[1])) {
                count++;
                list.add(inputs[0]);
            }
        }
        bw.write(count+"");
        bw.flush();
    }
}
