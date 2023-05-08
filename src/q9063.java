import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q9063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Integer> listX = new ArrayList<>();
        ArrayList<Integer> listY = new ArrayList<>();

        for(int i=0; i<N; i++) {
            listX.add(sc.nextInt());
            listY.add(sc.nextInt());
        }

        int w = Collections.max(listX) - Collections.min(listX);
        int h = Collections.max(listY) - Collections.min(listY);

        System.out.println(w*h);
    }
}