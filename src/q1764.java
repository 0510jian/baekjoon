import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] counts = br.readLine().split(" ");
        HashSet<String> setN = new HashSet<>();
        HashSet<String> setM = new HashSet<>();

        for(int i=0; i<Integer.parseInt(counts[0]); i++)
            setN.add(br.readLine());

        for(int i=0; i<Integer.parseInt(counts[1]); i++) {
            String input = br.readLine();
            if(setN.contains(input)) setM.add(input);
        }

        ArrayList<String> listM = new ArrayList<>(setM);
        Collections.sort(listM);
        bw.write(setM.size() + " \n");
        for(int i=0; i<setM.size(); i++)
            bw.write(listM.get(i) + "\n");
        bw.flush();
    }
}
