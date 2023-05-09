import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q14215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> points = new ArrayList<>();

        for(int i=0; i<3; i++)
            points.add(sc.nextInt());

        Collections.sort(points);
        if(points.get(0) + points.get(1) > points.get(2))
            System.out.print(points.get(0) + points.get(1) + points.get(2));
        else
            System.out.print((points.get(0) + points.get(1))*2-1);
    }
}
