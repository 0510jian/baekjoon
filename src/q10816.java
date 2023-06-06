import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] listN = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        Map<Integer, Integer> mapM = new HashMap<Integer, Integer>();
        int[] listM = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<M; i++)
            mapM.put(listM[i], 0);

        for(int i=0; i<N; i++) {
            if(mapM.containsKey(listN[i])) {
                int count = mapM.get(listN[i]);
                mapM.put(listN[i], count+1);
            }
        }
        for(int i=0; i<M; i++)
            bw.write(mapM.get(listM[i]) + " ");

        bw.flush();
    }
}
