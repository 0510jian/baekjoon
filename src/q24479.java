import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class q24479 {
    static int count = 0; // 방문 순서
    static ArrayList<ArrayList<Integer>> graph; // 인접리스트
    static int[] visit; // 방문 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        visit = new int[N+1];

        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            // v -> w 간선
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            // 양방향
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 오름차순 정렬
        for(int i=1; i<graph.size(); i++) Collections.sort(graph.get(i));

        // DFS 시작
        dfs(R);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<visit.length; i++) {
            sb.append(visit[i]).append("\n");
        }
        bw.write(String.valueOf(sb));

        bw.flush();
    }

    public static void dfs(int R) {
        visit[R] = ++count; // 방문

        for(int i : graph.get(R)) {
            if(visit[i] == 0) dfs(i);
        }
    }
}
