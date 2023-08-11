import java.io.*;
import java.util.*;

public class q24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int[] isQueuestack = new int[N];
        for(int i=0; i<N; i++) isQueuestack[i] = Integer.parseInt(tk.nextToken());

        tk = new StringTokenizer(br.readLine(), " ");
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<N; i++) {
            if(isQueuestack[i] == 0) deque.addFirst(Integer.parseInt(tk.nextToken()));
            else tk.nextToken();
        }

        int M = Integer.parseInt(br.readLine());
        tk = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            deque.addLast(Integer.parseInt(tk.nextToken()));
            bw.write(deque.pollFirst() + " ");
        }
        bw.flush();
    }
}
