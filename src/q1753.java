import java.io.*;
import java.util.*;

public class q1753 {
    public static class Node {
        int index, w; // 다음 목적지의 인덱스, 가중치
        Node(int index, int w) {
            this.index = index;
            this.w = w;
        }
    }

    static ArrayList<ArrayList> graph;
    static int V, E, K;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // V E K 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        // 그래프 생성
        graph = new ArrayList<>();
        for(int i=0; i<V+1; i++) graph.add(new ArrayList<Node>());
        for(int i=0; i<E; i++) {
            graph.add(new ArrayList());

            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // u->v(가중치w)
            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라
        dijkstra();

        // 출력
        for(int i=1; i< distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(distance[i] + "\n");
        }
        bw.flush();

    }

    public static void dijkstra() {
        // 최초 거리 확인
        distance = new int[V+1]; // 최단 거리 테이블
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V+1]; // 방문 여부 테이블

        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.w - o2.w));
        pq.offer(new Node(K, 0));
        distance[K] = 0;

        while(!pq.isEmpty()) {
            Node present = pq.poll();
            if(!visited[present.index]) visited[present.index] = true;

            // 현재 노드에서 방문 가능한 노드 순회
            for(Object NEXT : graph.get(present.index)) {
                Node next = (Node) NEXT;

                // 방문하지 않았고, 거리가 더 짧을 경우
                if(!visited[next.index] && distance[next.index] > distance[present.index] + next.w) {
                    distance[next.index] = distance[present.index] + next.w;
                    pq.offer(new Node(next.index, distance[next.index]));
                }
            }
        }
    }
}
