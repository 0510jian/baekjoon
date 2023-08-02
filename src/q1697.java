import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1697 {
    static int NUM = 100000;

    static class Node {
        int index;
        int w;

        Node(int i, int w) {
            this.index = i;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        bw.write(dijkstra(N, K) + "");
        bw.flush();
    }

    public static int dijkstra(int N, int K) {
        boolean[] visited = new boolean[NUM+1];
        visited[N] = true;

        int[] dist = new int[NUM+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.w - o2.w));
        pq.offer(new Node(N, 0));

        while(!pq.isEmpty()) {
            Node present = pq.poll();

            if(present.index - 1 >= 0 && present.index - 1 <= 100000) {
                Node next = new Node(present.index-1, 1);
                if(!visited[next.index] && dist[next.index] > dist[present.index] + next.w) {
                    dist[next.index] = dist[present.index] + next.w;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
            if(present.index + 1 >= 0 && present.index + 1 <= 100000) {
                Node next = new Node(present.index+1, 1);
                if(!visited[next.index] && dist[next.index] > dist[present.index] + next.w) {
                    dist[next.index] = dist[present.index] + next.w;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
            if(present.index * 2 >= 0 && present.index * 2 <= 100000) {
                Node next = new Node(present.index * 2, 1);
                if(!visited[next.index] && dist[next.index] > dist[present.index] + next.w) {
                    dist[next.index] = dist[present.index] + next.w;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }

        }

        return dist[K];
    }
}