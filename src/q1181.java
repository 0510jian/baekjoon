import java.util.*;

public class q1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        ArrayList<String> inputs = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String temp = sc.nextLine();
            if (!inputs.contains(temp)) inputs.add(temp);
        }

        Collections.sort(inputs);
        Collections.sort(inputs, Comparator.comparing(String::length));

        for (String input : inputs)
            System.out.println(input);
    }
}