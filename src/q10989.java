import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class q10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                list.add(input);
                map.put(input, 1);
            }
        }

        list.sort(Comparator.naturalOrder());
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<map.get(list.get(i)); j++) {
                bw.write(list.get(i)+"\n");
            }
        }
        bw.flush();
    }
}
