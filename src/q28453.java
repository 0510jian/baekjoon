import java.io.*;
import java.util.StringTokenizer;

public class q28453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            int M = Integer.parseInt(tk.nextToken());

            if(M < 250) {
                bw.write("4 ");
            } else if(M < 275) {
                bw.write("3 ");
            } else if(M < 300) {
                bw.write("2 ");
            } else {
                bw.write("1 ");
            }
        }
        bw.flush();
    }
}
