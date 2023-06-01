import java.io.*;
import java.util.*;

public class q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] M = br.readLine().split(" ");

        ArrayList<Integer> sortM = new ArrayList<>();
        for(String m : M)
            if(!sortM.contains(Integer.parseInt(m))) sortM.add(Integer.parseInt(m));
        sortM.sort(Comparator.naturalOrder());

        for(int i=0; i<M.length; i++) {
            for(int j=0; j<sortM.size(); j++) {
                if(sortM.get(j) == Integer.parseInt(M[i])) {
                    bw.write(j+" "); break;
                }
            }
        }
        bw.flush();
    }
}
