import java.io.*;
import java.util.HashSet;

public class q11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        HashSet<String> strs = new HashSet<>();

        for(int i=0; i<input.length(); i++) {
            for(int j=i+1; j<input.length()+1; j++) {
                strs.add(input.substring(i, j));
            }
        }
        bw.write(strs.size()+"");
        bw.flush();
    }
}
