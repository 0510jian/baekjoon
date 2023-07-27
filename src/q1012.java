import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class q1012 {
    static boolean[][] field;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int count;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int x=0; x<T; x++) {
            count = 1;

            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);

            // 배추 심기
            field = new boolean[N][M];
            for(int y=0; y<K; y++) {
                input = br.readLine().split(" ");
                field[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
            }
            visited = new int[N*M];
            
            // 그래프 생성
            graph = new ArrayList<>();
            for(int i=0; i<N*M; i++) graph.add(new ArrayList<>());
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(field[i][j]) {
                        try {
                            // 윗집 연결
                            if(field[i-1][j]) {
                                graph.get(i*M + j).add((i-1)*M + j);
                            }
                        } catch (Exception e) {}

                        try {
                            // 아랫집 연결
                            if(field[i+1][j]) {
                                graph.get(i*M + j).add((i+1)*M + j);
                            }
                        } catch (Exception e) {}

                        try {
                            // 왼쪽집 연결
                            if(field[i][j-1]) {
                                graph.get(i*M + j).add(i*M + (j-1));
                            }
                        } catch (Exception e) {}

                        try {
                            // 오른쪽집 연결
                            if(field[i][j+1]) {
                                graph.get(i*M + j).add(i*M + (j+1));
                            }
                        } catch (Exception e) {}
                    }
                }
            }

            // dfs
            for(int i=0; i<N*M; i++) {
                if(dfs(i)) count++;
            }

            // 지렁이 수 출력
            bw.write(count-1+"\n");
        }
        bw.flush();
    }

    public static boolean dfs(int R) {
        if(field[R/M][R%M] && visited[R] == 0) {
            visited[R] = count;

            for(int v : graph.get(R)) {
                if(visited[v] == 0) dfs(v);
            }

            return true;
        }
        return false;
    }
}
