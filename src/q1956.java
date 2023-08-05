import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1956 {
    static int INF = 10000000;
    static int V, E;
    static int result = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(tk.nextToken());
        E = Integer.parseInt(tk.nextToken());

        int[][] dist = new int[V+1][V+1];
        for(int k=0; k<V+1; k++) {
            Arrays.fill(dist[k], INF);
        }
        for(int k=0; k<E; k++) {
            tk = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            int w = Integer.parseInt(tk.nextToken());

            dist[u][v] = w;
        }

        for(int y=1; y<V+1; y++) {
            for(int x=1; x<V+1; x++) {
                for(int z=1; z<V+1; z++) {
                    if(x == z) continue;
                    if(dist[x][z] > dist[x][y] + dist[y][z]) {
                        dist[x][z] = dist[x][y] + dist[y][z];
                    }
                }
            }
        }

        for(int i=1; i<V; i++) {
            for(int j=i; j<V+1; j++) {
                if(dist[i][j] != INF && dist[j][i] != INF) {
                    if(result > dist[i][j] + dist[j][i]) result = dist[i][j] + dist[j][i];
                }
            }
        }

        if(result == INF) result = -1;

        bw.write(result + "");
        bw.flush();
    }
}
