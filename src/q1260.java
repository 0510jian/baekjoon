import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class q1260 {
    static boolean[] visitDFS;
    static ArrayList<Integer> visitSequenceDfs = new ArrayList<>();

    static boolean[] visitBFS;
    static ArrayList<Integer> queueBfs = new ArrayList<>();
    static ArrayList<Integer> visitSequenceBfs = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        visitBFS = new boolean[N+1];
        visitDFS = new boolean[N+1];
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=1; i<graph.size(); i++) Collections.sort(graph.get(i));

        dfs(V);
        bfs(V);

        StringBuilder sbDfs = new StringBuilder();
        StringBuilder sbBfs = new StringBuilder();
        for(int i=0; i<visitSequenceDfs.size(); i++) sbDfs.append(visitSequenceDfs.get(i)).append(" ");
        for(int i=0; i<visitSequenceBfs.size(); i++) sbBfs.append(visitSequenceBfs.get(i)).append(" ");
        bw.write(sbDfs + "\n");
        bw.write(sbBfs + "");

        bw.flush();
    }

    public static void dfs(int R) {
        visitDFS[R] = true;
        visitSequenceDfs.add(R);
        for(int v : graph.get(R)) {
            if(!visitDFS[v]) dfs(v);
        }
    }

    public static void bfs(int R) {
        visitBFS[R] = true;
        visitSequenceBfs.add(R);
        enqueue(R);

        while(queueBfs.size() != 0) {
            int u = dequeue();
            for(int v : graph.get(u)) {
                if(!visitBFS[v]) {
                    visitBFS[v] = true;
                    visitSequenceBfs.add(v);
                    enqueue(v);
                }
            }
        }
    }

    public static void enqueue(int v) {
        queueBfs.add(v);
    }

    public static int dequeue() {
        int v = queueBfs.get(0);
        queueBfs.remove(0);
        return v;
    }
}
