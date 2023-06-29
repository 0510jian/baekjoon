import java.util.*;

public class q1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        int[] list = new int[count];
        for(int i=0; i<count; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);

        System.out.print(list[0]*list[list.length-1]);
    }
}