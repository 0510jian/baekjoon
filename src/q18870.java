import java.io.*;
import java.util.*;

public class q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] M = br.readLine().split(" ");
        ArrayList<Integer> sortM = new ArrayList<>();
        for(int i=0; i<N; i++) {
            sortM.add(Integer.parseInt(M[i]));
        }
        sortM.sort(Comparator.naturalOrder());

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for(int m : sortM) {
            if(!map.containsKey(m)) {
                map.put(m, count);
                count++;
            }
        }

        for(int i=0; i<N; i++) {
            bw.write(map.get(Integer.parseInt(M[i])) + " ");
        }
        bw.flush();
    }
}
