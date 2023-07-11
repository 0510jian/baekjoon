import java.util.ArrayList;
import java.util.Scanner;

public class q15649 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 각 자리마다 출력 가능한 수 리스트
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=0; i<N; i++) {
            numbers.add(i+1);
        }

        // start_node(1,2,3,4) 지정
        for(int i=0; i<N; i++) {
            int startNode = numbers.get(i);
            ArrayList<Integer> visited = new ArrayList<>();
            ArrayList<Integer> needVisit = new ArrayList<>();
            for(int num : numbers) needVisit.add(num);

            backtracking(startNode, visited, needVisit, M);
        }
    }

    public static void backtracking(int startNode, ArrayList<Integer> visited, ArrayList<Integer> needVisit, int M) {
        visited.add(startNode);
        if(visited.size() == M) { // 칸수(M) 채우면 출력 후 return
            for(int num : visited) System.out.print(num + " ");
            System.out.println();
            return;
        }
        needVisit.remove(new Integer(startNode));

        for(int node : needVisit) {
            backtracking(node, (ArrayList<Integer>) visited.clone(), (ArrayList<Integer>) needVisit.clone(), M);
        }
    }
}
