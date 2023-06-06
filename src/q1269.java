import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class q1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        String[] temp;

        br.readLine();
        temp = br.readLine().split(" ");
        for(int i=0; i<temp.length; i++)
            A.add(Integer.parseInt(temp[i]));
        temp = br.readLine().split(" ");
        for(int i=0; i<temp.length; i++)
            B.add(Integer.parseInt(temp[i]));

        result = (HashSet<Integer>) A.clone();
        result.removeAll(B);
        B.removeAll(A);
        result.addAll(B);

        bw.write(result.size()+"");
        bw.flush();
    }
}
