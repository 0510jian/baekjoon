import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class q2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> inputs = new ArrayList<Integer>();

        int sum = 0;
        for(int i=0; i<N; i++) {
            inputs.add(sc.nextInt());
            sum += inputs.get(inputs.size()-1);
        }
        Collections.sort(inputs);

        // 산술평균
        System.out.println(Math.round((float)sum/N));

        // 중앙값
        System.out.println(inputs.get(Math.round(inputs.size()/2)));

        // 최빈값
        ArrayList<Integer> frequentList = frequent(inputs);
        if(frequentList.size() > 1) {
            System.out.println(frequentList.get(1));
        } else {
            System.out.println(frequentList.get(0));
        }

        // 범위
        System.out.println(inputs.get(inputs.size()-1) - inputs.get(0));
    }

    public static ArrayList<Integer> frequent(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();

        int max = 1;
        for(int i=0; i<list.size(); i++) {
            if(map.containsKey(list.get(i))) {
                int count = map.get(list.get(i));
                map.put(list.get(i), ++count);
                if(count > max) max = count;
            } else {
                map.put(list.get(i), 1);
            }
        }

        for(int key : map.keySet()) {
            if(map.get(key).equals(max)) {
                output.add(key);
            }
        }
        Collections.sort(output);

        return output;
    }
}
