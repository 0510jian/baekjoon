import java.io.*;
import java.util.ArrayList;

public class q15651 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<N+1; i++) list.add(i);

        for(int i=0; i<list.size(); i++) {
            int startNode = list.get(i);
            ArrayList<Integer> visited = new ArrayList<>();
            ArrayList<Integer> needVisit = (ArrayList<Integer>) list.clone();

            backtracking(startNode, visited, needVisit, M, bw);
        }
        bw.flush();
    }

    public static void backtracking(int startNode, ArrayList<Integer> visited, ArrayList<Integer> needVisit, int M, BufferedWriter bw) throws IOException {
        // 자리에 숫자 넣기
        visited.add(startNode);

        // 자릿수 full
        if(visited.size() == M) {
            for(int num : visited) {
                bw.write(num + " ");
            }
            bw.write("\n");
        } else {
            for(int i=0; i<needVisit.size(); i++) {
                backtracking(needVisit.get(i), (ArrayList<Integer>)visited.clone(), (ArrayList<Integer>)needVisit.clone(), M, bw);
            }
        }
    }
}
