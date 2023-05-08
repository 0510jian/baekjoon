import java.util.ArrayList;
import java.util.Scanner;

public class q3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> pointsX = new ArrayList<>();
        ArrayList<Integer> pointsY = new ArrayList<>();

        // point 목록 중 남은 것을 고르면 된다
        for(int i=0; i<3; i++) {
            int tempX = sc.nextInt();
            if(pointsX.contains(tempX)) pointsX.remove(Integer.valueOf(tempX));
            else pointsX.add(tempX);

            int tempY = sc.nextInt();
            if(pointsY.contains(tempY)) pointsY.remove(Integer.valueOf(tempY));
            else pointsY.add(tempY);
        }
        System.out.print(pointsX.get(0) + " " + pointsY.get(0));
    }
}