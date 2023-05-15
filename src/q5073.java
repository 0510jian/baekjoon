import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q5073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> results = new ArrayList<>();

        while(true) {
            ArrayList<Integer> points = new ArrayList<>();
            for(int i=0; i<3; i++) {
                points.add(sc.nextInt());
            }

            // 0 0 0 입력 시 종료
            if((points.get(0) + points.get(1) + points.get(2)) == 0) break;

            // points 리스트 정렬
            Collections.sort(points);

            // 삼각형의 조건 만족시키지 못하면 Invalid
            if(points.get(0) + points.get(1) <= points.get(2)) results.add("Invalid");

            else if(points.get(0) == points.get(1) && points.get(1) == points.get(2)) results.add("Equilateral");
            else if(points.get(0) == points.get(1) || points.get(1) == points.get(2) || points.get(0) == points.get(2)) results.add("Isosceles");
            else results.add("Scalene");
        }

        // 전체 결과 출력
        for (String result: results) {
            System.out.println(result);
        }
    }
}