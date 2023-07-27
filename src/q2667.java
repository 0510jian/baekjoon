import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class q2667 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][] house;
    static int N;
    static int[] visited;
    static int count = 1;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        house = new boolean[N][N];
        visited = new int[N*N];

        // 집 있는 곳 : 1, 집 없는 곳 : 0 표시
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++) {
                if(input[j].equals("1")) house[i][j] = true;
            }
        }

        // 그래프 생성
        graph = new ArrayList<>();
        for(int i=0; i<N*N; i++) graph.add(new ArrayList<>());
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(house[i][j]) {
                    try {
                        // 윗집 연결
                        if(house[i-1][j]) {
                            graph.get(i*N + j).add((i-1)*N + j);
                        }
                    } catch (Exception e) {}

                    try {
                        // 아랫집 연결
                        if(house[i+1][j]) {
                            graph.get(i*N + j).add((i+1)*N + j);
                        }
                    } catch (Exception e) {}

                    try {
                        // 왼쪽집 연결
                        if(house[i][j-1]) {
                            graph.get(i*N + j).add(i*N + (j-1));
                        }
                    } catch (Exception e) {}

                    try {
                        // 오른쪽집 연결
                        if(house[i][j+1]) {
                            graph.get(i*N + j).add(i*N + (j+1));
                        }
                    } catch (Exception e) {}
                }
            }
        }

        // dfs
        for(int i=0; i<N*N; i++) {
            if(dfs(i)) count++;
        }

        // 아파트 단지 카운트
        int[] countComplex = new int[count];
        for(int i=0; i<N*N; i++) {
            if(visited[i] != 0) countComplex[visited[i]]++;
        }
        Arrays.sort(countComplex);
        countComplex[0] = count-1;
        
        // 아파트 단지 출력
        for(int i=0; i<countComplex.length; i++) bw.write(countComplex[i]+"\n");
        bw.flush();
    }

    public static boolean dfs(int R) {
        if(house[R/N][R%N] && visited[R] == 0) {
            visited[R] = count;

            for(int v : graph.get(R)) {
                if(visited[v] == 0) dfs(v);
            }

            return true;
        }
        return false;
    }
}
