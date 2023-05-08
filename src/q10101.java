import java.util.ArrayList;
import java.util.Scanner;

public class q10101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] points = new int[3];
        int sum = 0;

        for(int i=0; i<3; i++) {
            points[i] = sc.nextInt();
            sum += points[i];
        }

        if(sum != 180) System.out.print("Error");
        else if(points[0] == 60 && points[1] == 60) System.out.print("Equilateral");
        else if(points[0] == points[1] || points[1] == points[2] || points[0] == points[2]) System.out.print("Isosceles");
        else System.out.print("Scalene");
    }
}