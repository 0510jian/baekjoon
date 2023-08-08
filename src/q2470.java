import java.io.*;
import java.util.*;

public class q2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int tkCount = tk.countTokens();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<tkCount; i++) list.add(Integer.parseInt(tk.nextToken()));
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int[] result = {1000000001, 1000000001};
        int sum = result[0] + result[1];
        for(int i=0; i<list.size()-1; i++) {
            int temp = Math.abs(list.get(i) + list.get(i+1));
            if(temp < sum) {
                result[0] = list.get(i);
                result[1] = list.get(i+1);
                sum = temp;
            }
        }
        Arrays.sort(result);
        bw.write(result[0] + " " + result[1]);
        bw.flush();
    }
}
