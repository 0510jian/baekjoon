import java.io.*;
import java.util.ArrayList;

public class q2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int startIndex = 0;
        int endIndex = N-1;

        int[] queue = new int[N*2];
        for(int i=0; i<queue.length; i++) {
            queue[i] = i+1;
        }

        for(int i=0; i<N-1; i++) {
            queue[++endIndex] = queue[++startIndex];
            startIndex++;
        }

        bw.write(queue[endIndex]+"");
        bw.flush();
    }
}