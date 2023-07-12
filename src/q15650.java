import java.util.ArrayList;
import java.util.Scanner;

public class q15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<N+1; i++) list.add(i);

        for(int i=0; i<list.size(); i++) {
            int startNode = list.get(i);
            ArrayList<Integer> visited = new ArrayList<>();
            ArrayList<Integer> needVisit = (ArrayList<Integer>) list.clone();

            backtracking(startNode, visited, needVisit, M);
        }
    }

    public static void backtracking(int startNode, ArrayList<Integer> visited, ArrayList<Integer> needVisit, int M) {
        // 자리에 숫자 넣기
        visited.add(startNode);

        // 해당 숫자와 같거나 보다 작은 숫자를 삭제
        for(int i=1; i<startNode+1; i++) {
            if(needVisit.contains(i)) needVisit.remove(new Integer(i));
        }

        // 자릿수 full
        if(visited.size() == M) {
            for(int num : visited) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // 남은 자릿수 백ㄹ킹
        for(int i=0; i<needVisit.size(); i++) {
            backtracking(needVisit.get(i), (ArrayList<Integer>)visited.clone(), (ArrayList<Integer>)needVisit.clone(), M);
        }
    }
}
