import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11404 {
    public static void main(String[] args) throws IOException {
        int INF = 10000000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // dist 테이블 생성 및 초기화
        int[][] dist = new int[n+1][n+1];
        for(int k=0; k<dist.length; k++) Arrays.fill(dist[k], INF);

        // dist 테이블 세팅
        StringTokenizer tk;
        for(int k=0; k<m; k++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(tk.nextToken());
            int j = Integer.parseInt(tk.nextToken());
            int w = Integer.parseInt(tk.nextToken());

            if(dist[i][j] != INF) {
                dist[i][j] = Math.min(dist[i][j], w);
            } else {
                dist[i][j] = w;
            }

        }

        // x: 거쳐가는 노드, y:시작노드, z:종료노드
        for(int y=1; y<n+1; y++) {
            for(int x=1; x<n+1; x++) {
                for(int z=1; z<n+1; z++) {
                    // 시작-종료가 같을 수 없음
                    if(x == z) continue;

                    if(dist[x][z] > dist[x][y] + dist[y][z]) {
                        dist[x][z] = dist[x][y] + dist[y][z];
                    }
                }
            }

        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(dist[i][j] == INF) bw.write("0 ");
                else bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
