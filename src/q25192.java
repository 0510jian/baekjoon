import java.io.*;
import java.util.HashSet;

public class q25192 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> list= new HashSet<String>();
        int count = 0;
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            if(input.equals("ENTER")) list.clear();
            else if(!list.contains(input)) {
                list.add(input);
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
    }
}
