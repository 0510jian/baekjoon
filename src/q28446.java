import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q28446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> locker = new HashMap<>();
        for(int i=0; i<M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(tk.nextToken());

            if(command == 1) {
                int index = Integer.parseInt(tk.nextToken());
                int w = Integer.parseInt(tk.nextToken());
                locker.put(w, index);
            } else {
                int w = Integer.parseInt(tk.nextToken());
                bw.write(locker.get(w) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
