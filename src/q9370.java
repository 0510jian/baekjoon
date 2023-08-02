import java.io.*;
import java.util.*;

public class q9370 {
    static class Node {
        int index;
        int w;

        Node(int index, int w) {
            this.index = index;
            this.w = w;
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    static int n, m, t, s, g, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(tk.nextToken()); // 교차로
            m = Integer.parseInt(tk.nextToken()); // 도로
            t = Integer.parseInt(tk.nextToken()); // 목적지 후보 개수
            int[] dest = new int[t];

            tk = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(tk.nextToken()); // 예술가 출발지
            g = Integer.parseInt(tk.nextToken()); // 거쳐감1
            h = Integer.parseInt(tk.nextToken()); // 거쳐감2

            // 인접리스트 생성
            graph = new ArrayList<>();
            for(int j=0; j<n+1; j++) graph.add(new ArrayList<>());
            for(int j=0; j<m; j++) {
                tk = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(tk.nextToken());
                int b = Integer.parseInt(tk.nextToken());
                int d = Integer.parseInt(tk.nextToken());

                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }
            // 목적지 후보 입력
            for(int j=0; j<t; j++) dest[j] = Integer.parseInt(br.readLine());

            // s -> g || s -> h
            int[] dist = dijkstra(s);
            boolean sToG = true, sToH = true;
            if(dist[g] == Integer.MAX_VALUE) sToG = false;
            if(dist[h] == Integer.MAX_VALUE) sToH = false;
            int distSToG = dist[g];
            int distSToH = dist[h];

            // g -> h || h -> g
            dist = dijkstra(g);
            int distMiddle = dist[h];

            // h -> d || g -> d (단 최적의 s->d와 값이 같아야함 : 최단 거리 이동했기 때문)
            ArrayList<Integer> possibleDest = new ArrayList<>();
            for(int j=0; j<dest.length; j++) {
                int destination = dest[j];

                // 최적 s -> d
                dist = dijkstra(s);
                boolean sToD = true;
                if(dist[destination] == Integer.MAX_VALUE) sToD = false;
                int distSToD = dist[destination];

                // g -> d
                dist = dijkstra(g);
                boolean gToD = true;
                if(dist[destination] == Integer.MAX_VALUE) gToD = false;
                int distGToD = dist[destination];

                // h -> d
                dist = dijkstra(h);
                boolean hToD = true;
                if(dist[destination] == Integer.MAX_VALUE) hToD = false;
                int distHToD = dist[destination];

                // s -> d 경로가 없을 경우
                if(!sToD) continue;

                // s -> g -> h -> d
                if((sToG && hToD) && (distSToD == distSToG + distMiddle + distHToD)) possibleDest.add(destination);
                // s -> h -> g -> d
                else if((sToH && gToD) && (distSToD == distSToH + distMiddle + distGToD)) possibleDest.add(destination);
            }
            
            // 결과 출력
            Collections.sort(possibleDest);
            for(int j=0; j<possibleDest.size(); j++) {
                bw.write(possibleDest.get(j) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static int[] dijkstra(int S) {
        boolean[] visited = new boolean[n+1];
        visited[S] = true;

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Node(S, 0));

        while(!pq.isEmpty()) {
            Node present = pq.poll();

            for(Object NEXT : graph.get(present.index)) {
                Node next = (Node) NEXT;
                if(!visited[next.index] && dist[next.index] > dist[present.index] + next.w) {
                    dist[next.index] = dist[present.index] + next.w;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist;
    }
}