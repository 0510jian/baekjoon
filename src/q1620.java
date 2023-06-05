import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String NM[] = br.readLine().split(" ");
        Map<String, Integer> listsStr = new HashMap<String, Integer>();
        Map<Integer, String> listsInt = new HashMap<Integer, String>();

        for(int i=0; i<Integer.parseInt(NM[0]); i++) {
            String input = br.readLine();
            listsStr.put(input, i);
            listsInt.put(i, input);
            }

        for(int i=0; i<Integer.parseInt(NM[1]); i++) {
            String input = br.readLine();
            try { // 숫자일 경우
                bw.write(listsInt.get(Integer.parseInt(input) - 1) + "\n");
            } catch (NumberFormatException e) { // 문자일 경우
                bw.write(listsStr.get(input) + 1 + "\n");
            }
        }
        bw.flush();
    }
}
