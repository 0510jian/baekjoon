import java.util.ArrayList;
import java.util.Scanner;

public class q4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String[] inputs = sc.nextLine().split("");
            if(inputs.length == 1 && inputs[0].equals(".")) break;

            ArrayList<String> result = new ArrayList<String>();
            int countBreak = 0;

            for(String input : inputs) {
                if(input.equals("(")) {
                    result.add("(");
                } else if(input.equals("[")) {
                    result.add("[");
                } else if(input.equals(")")) {
                    if(result.size() > 0 && result.get(result.size()-1).equals("(")) {
                        result.remove(result.size()-1);
                    } else {
                        countBreak++;
                        break;
                    }
                } else if(input.equals("]")) {
                    if(result.size() > 0 && result.get(result.size()-1).equals("[")) {
                        result.remove(result.size()-1);
                    } else {
                        countBreak++;
                        break;
                    }
                }
            }
            if(countBreak == 0 && result.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
