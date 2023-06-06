import java.io.*;
import java.util.*;

public class q7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> emps = new HashSet<>();

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            if (emps.contains(input[0])) emps.remove(input[0]);
            else emps.add(input[0]);
        }

        ArrayList<String> listEmps = new ArrayList<>(emps);
        Collections.sort(listEmps, Comparator.reverseOrder());
        for(String emp : listEmps)
            bw.write(emp+"\n");
        bw.flush();
    }
}
