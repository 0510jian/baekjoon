import java.util.ArrayList;
import java.util.Scanner;

public class q1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String[] splitS = S.split("");

        ArrayList<String> list = new ArrayList<>();
        int s = 0, e = 0;
        for(int i=0; i<splitS.length; i++) {
            if(splitS[i].equals("+") || splitS[i].equals("-") || i == splitS.length-1) {
                if(i == splitS.length-1) e = i+1;
                else e = i;

                list.add(S.substring(s, e));
                if(i != splitS.length-1) list.add(splitS[i]);

                s = i+1;
            }
        }

        int total = 0;
        boolean isMinus = false;
        for(int i=0; i< list.size(); i++) {
            if(list.get(i).equals("-") || list.get(i).equals("+")) {
                if(list.get(i).equals("-")) isMinus = true;
                continue;
            }
            if(isMinus) {
                total -= Integer.parseInt(list.get(i));
            } else {
                total += Integer.parseInt(list.get(i));
            }
        }
        System.out.println(total);
    }
}
