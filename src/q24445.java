import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class q24445 {
    static int[] visited; // 정점의 방문여부 체크
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> queue = new ArrayList<>();
    static int visitCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        visited = new int[N+1];
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) graph.add(new ArrayList<>());

        // 간선 인접 리스트 만들기
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            // 양방향 간선
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 인접리스트 오름차순 정렬
        for(int i=1; i<graph.size(); i++) Collections.sort(graph.get(i), Collections.reverseOrder());

        // 너비 우선 탐색 실행
        bfs(R);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1; i++) sb.append(visited[i]).append("\n");
        bw.write(String.valueOf(sb));

        bw.flush();
    }

    public static void bfs(int R) {
        visited[R] = ++visitCount;

        // 큐에 시작 정점 R 추가
        enqueue(R);

        while(queue.size() != 0) {
            int u = dequeue();
            for(int v : graph.get(u)) { // 정점 u의 인접 정점 집합
                if(visited[v] == 0) {
                    visited[v] = ++visitCount;
                    enqueue(v);
                }
            }
        }
    }

    public static void enqueue(int v) {
        queue.add(v);
    }

    public static int dequeue() {
        int v = queue.get(0);
        queue.remove(0);
        return v;
    }
}
