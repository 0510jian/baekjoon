import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class q1697 {
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static ArrayList<Integer> queue;

    public static int[][] list = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int r=0; r<T; r++) {
            // 체스판 정의
            int l = Integer.parseInt(br.readLine());
            visited = new boolean[l*l];

            // 그래프 생성
            graph = new ArrayList<>();
            for(int i = 0; i<l*l; i++) graph.add(new ArrayList<>());
            for(int i=0; i<l; i++) {
                for(int j=0; j<l; j++) {
                    for (int k = 0; k < list.length; k++) {
                        int a = list[k][0];
                        int b = list[k][1];
                        if(i+a >= 0 && i+a < l && j+b >= 0 && j+b < l)
                            graph.get(i*l + j).add((i+a)*l + (j+b));
                    }
                }
            }

            // 좌표 입력
            String[] input = br.readLine().split(" ");
            int startA = Integer.parseInt(input[0]);
            int startB = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            int endA = Integer.parseInt(input[0]);
            int endB = Integer.parseInt(input[1]);

            // bfs
            queue = new ArrayList<>();
            bw.write(bfs(startA*l + startB, endA*l+endB) + "\n");
        }
        bw.flush();
    }

    public static int bfs(int S, int E) {
        HashMap<Integer, Integer> map = new HashMap<>();

        visited[S] = true;
        map.put(S, 0);
        enqueue(S);

        while(queue.size() > 0) {
            int u = dequeue();
            if(visited[E]) return map.get(E);

            for(int v : graph.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    enqueue(v);
                    map.put(v, map.get(u)+1);
                }
            }
        }
        return 0;
    }

    public static void enqueue(int v) {
        queue.add(v);
    }

    public static int dequeue() {
        int output = queue.get(0);
        queue.remove(0);
        return output;
    }
}
