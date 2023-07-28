import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class q2178 {
    public static ArrayList<Integer> queue = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] visited;
    public static boolean[][] maze;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 미로 생성
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new int[N*M];

        maze = new boolean[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split("");
            for(int j=0; j<M; j++) {
                maze[i][j] = (Integer.parseInt(input[j]) != 0);
            }
        }

        // 그래프 생성
        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                graph.add(new ArrayList<>());
                if(maze[i][j]) {
                    // 위 연결
                    try {
                        if(maze[i-1][j]) graph.get(i*M + j).add((i-1)*M + j);
                    } catch (Exception e) {}

                    // 아래 연결
                    try {
                        if(maze[i+1][j]) graph.get(i*M + j).add((i+1)*M + j);
                    } catch (Exception e) {}

                    // 왼쪽 연결
                    try {
                        if(maze[i][j-1]) graph.get(i*M + j).add(i*M + (j-1));
                    } catch (Exception e) {}

                    // 오른쪽 연결
                    try {
                        if(maze[i][j+1]) graph.get(i*M + j).add(i*M + (j+1));
                    } catch (Exception e) {}
                }
            }
        }

        // bfs
        bfs(0);

        bw.write(visited[N*M-1] + "");
        bw.flush();

    }

    public static void bfs(int R) {
        HashMap<Integer, Integer> parent = new HashMap<>();
        if(maze[R/M][R%M]) {
            visited[R] = 1;
            enqueue(R);

            while(queue.size() > 0) {
                int u = dequeue();
                for(int v : graph.get(u)) {
                    
                    // 부모 확인
                    if(!parent.containsKey(v)) {
                        parent.put(v, u);
                    } else {
                        // 만약 새로운 부모의 visit값이 현재 부모의 visit값보다 작을 경우 부모 갱신
                        if(visited[u] < visited[parent.get(v)]) parent.put(v, u);
                    }

                    // 방문한 적 없거나 두번째 방문의 visit값이 더 작은 경우(더 빠른 경로가 있을 경우)
                    if(visited[v] == 0 || visited[v] > visited[parent.get(v)] + 1) {
                        // 한 부모(이전 좌표값)에서 나온 자식은 같은 카운트 수를 가진다
                        visited[v] = visited[parent.get(v)] + 1;
                        enqueue(v);
                    }
                }
            }
        }
    }

    public static void enqueue(int v) {
        queue.add(v);
    }

    public static int dequeue() {
        int out = queue.get(queue.size()-1);
        queue.remove(queue.size()-1);
        return out;
    }
}