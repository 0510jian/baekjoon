import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class q1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strN = String.valueOf(sc.nextInt());

        ArrayList<Integer> listN = new ArrayList<>();

        for(int i=0; i<strN.length(); i++)
            listN.add(Integer.parseInt(String.valueOf(strN.charAt(i))));

        listN.sort(Comparator.reverseOrder());

        for(int n : listN)
            System.out.print(n);
    }
}
