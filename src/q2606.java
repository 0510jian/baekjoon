import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class q2606 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);

        int result = 0;
        for(int i=2; i<visited.length; i++) {
            if(visited[i]) result++;
        }
        bw.write(result+"");
        bw.flush();
    }

    public static void dfs(int R) {
        visited[R] = true;
        for(int Rc : graph.get(R)) {
            if(!visited[Rc]) dfs(Rc);
        }
    }
}
