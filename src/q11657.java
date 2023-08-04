import java.io.*;
import java.util.*;

public class q11657 {
    static class Node {
        int u;
        int v;
        int w;

        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static ArrayList<Node> graph = new ArrayList<>();
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        for(int i=0; i<M; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            int w = Integer.parseInt(tk.nextToken());

            graph.add(new Node(u, v, w));
        }

        bellmanford(bw, 1);
    }

    public static void bellmanford(BufferedWriter bw, int s) throws IOException {
        long[] dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                Node present = graph.get(j);

                if(dist[present.u] != Integer.MAX_VALUE && dist[present.v] > dist[present.u] + present.w) {
                    dist[present.v] = dist[present.u] + present.w;
                }
            }
        }

        // 무한 음수
        for(int i=0; i<M; i++) {
            Node present = graph.get(i);

            if(dist[present.u] != Integer.MAX_VALUE && dist[present.v] > dist[present.u] + present.w) {
                bw.write("-1");
                bw.flush();
                System.exit(0);
            }
        }

        // 그 외 최종
        for(int i=2; i<N+1; i++) {
            if(dist[i] == Integer.MAX_VALUE) bw.write("-1\n");
            else bw.write(dist[i] + "\n");
        }

        bw.flush();
    }
}
