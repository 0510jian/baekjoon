import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class q2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> inputs = new ArrayList<>();

        for(int i=0; i<N; i++)
            inputs.add(Integer.parseInt(br.readLine()));

        Collections.sort(inputs);

        for (int input: inputs)
            bw.write(String.valueOf(input)+"\n");

        bw.flush();
    }
}
