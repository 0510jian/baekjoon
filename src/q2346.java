import java.io.*;
import java.util.StringTokenizer;

public class q2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        int[] ballons = new int[N];
        boolean[] visit = new boolean[N];
        for(int i=0; i<N; i++) {
            ballons[i] = Integer.parseInt(tk.nextToken());
            visit[i] = false;
        }

        int index = 0, nextIndex = 0;
        while(true) {
            bw.write((index+1) + " ");
            visit[index] = true;

            int count = 0;
            for(int i=0; i<N; i++) if(!visit[i]) count++;
            if(count <= 0) break;

            nextIndex = index;
            if(ballons[index] > 0) {
                for(int i=0; i<ballons[index]; i++) {
                    while(true) {
                        nextIndex++;
                        if(nextIndex >= N) nextIndex -= N;

                        if(!visit[nextIndex]) break;
                    }
                }
            } else {
                for(int i=0; i<ballons[index]*(-1); i++) {
                    while(true) {
                        nextIndex--;
                        if(nextIndex < 0) nextIndex += N;

                        if(!visit[nextIndex]) break;
                    }
                }
            }
            index = nextIndex;
        }
        bw.flush();
    }
}
