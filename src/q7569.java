import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q7569 {
    static int[][][] box; // 토마토 박스
    static int[][] neighbor = {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {1, 0, 0}, {-1, 0, 0}}; // 이웃 여부
    static int N, M, H;
    static Queue<Integer> queue = new LinkedList<Integer>();

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 박스 세팅
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        // 토마토 세팅
        for(int h=0; h<H; h++) {
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<M; j++) {
                    box[h][i][j] = Integer.parseInt(st.nextToken());

                    // 이미 익은 토마토일 경우
                    if(box[h][i][j] == 1) queue.add(h*M*N + i*M + j);
                }
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
                int origH = u/(N*M);
                int origI = (u%(N*M))/M;
                int origJ = (u%(N*M))%M;
                int h = origH + neighbor[k][0];
                int i = origI + neighbor[k][1]; // 인접값
                int j = origJ + neighbor[k][2]; // 인접값


                if(h<0 || h>=H || i<0 || i>=N || j<0 || j>=M) continue;
                if(box[h][i][j] != 0) continue;

                box[h][i][j] = box[origH][origI][origJ] + 1;
                queue.add(h*N*M + i*M + j);

                // 최댓값 세팅
                if(max < box[origH][origI][origJ]) max = box[origH][origI][origJ];
            }
        }



        int max = 0;
        for(int h=0; h<H; h++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(box[h][i][j] == 0) return -1;
                    max = Math.max(max, box[h][i][j]);
                }
            }
        }

        if(max == 1) return 0;
        return max-1;
    }
}
