import java.util.ArrayList;
import java.util.Scanner;

public class q1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        int count = 1; // stack에 push할 수

        for(int i=0; i<N; i++) {
            try {
                int input = sc.nextInt();

                // 스택이 비었거나 스택의 마지막 값이 input보다 작을 경우
                // input값까지 스택에 count push
                if(stack.size() == 0 || stack.get(stack.size()-1) < input) {
                    for(int j=count; j<=input; j++) {
                        stack.add(count);
                        count++;
                        result.add("+");
                    }
                    // input값 pop
                    stack.remove(stack.size()-1);
                    result.add("-");
                    
                // 스택의 마지막 값이 input보다 클 경우 => pop만 하면 됨
                } else if(stack.get(stack.size()-1) >= input) {
                    for(int j=stack.get(stack.size()-1); j>= input; j--) {
                        stack.remove(stack.size()-1);
                        result.add("-");
                    }
                }

            // 다음 값으로 넘어가지 못하면 수열 생성 불가능
            } catch(IndexOutOfBoundsException e) {
                System.out.println("NO");
                return;
            }
        }

        // 최종 결과 출력
        for(String res : result) {
            System.out.println(res);
        }
    }
}