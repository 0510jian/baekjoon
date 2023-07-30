import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q7576 {
    static int[][] box; // 토마토 박스
    static int[][] neighbor = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 이웃 여부
    static int N, M;
    static Queue<Integer> queue = new LinkedList<Integer>();

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 박스 세팅
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        // 토마토 세팅
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                // 이미 익은 토마토일 경우
                if(box[i][j] == 1) queue.add(i*M+j);
            }
        }

        //bfs
        bw.write(bfs()+"");
        bw.flush();
    }

    public static int bfs() {
        while(queue.size() > 0) {
            int u = queue.poll();

            // 인접리스트
            for(int k=0; k<neighbor.length; k++) {
                int i = (u/M) + neighbor[k][0]; // 인접값
                int j = (u%M) + neighbor[k][1]; // 인접값

                if(i<0 || i>=N || j<0 || j>=M) continue;
                if(box[i][j] != 0) continue;

                box[i][j] = box[u/M][u%M] + 1;
                queue.add(i*M+j);

                // 최댓값 세팅
                if(max < box[u/M][u%M]) max = box[u/M][u%M];
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0) return -1;
                max = Math.max(max, box[i][j]);
            }
        }
        if(max == 1) return 0;
        return max-1;
    }
}
