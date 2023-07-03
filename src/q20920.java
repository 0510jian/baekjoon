import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q20920 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputNM = br.readLine().split(" ");

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<Integer.parseInt(inputNM[0]); i++) {
            String input = br.readLine();
            if(input.length() >= Integer.parseInt(inputNM[1])) {
                if(map.containsKey(input)) {
                    map.put(input, map.get(input) + 1);
                } else {
                    map.put(input, 1);
                }
            }
        }

        // 1. 알파벳 사전순
        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Comparator.naturalOrder());

        // 2. 길이가 긴 순
        keyList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        // 3. 자주 나오는 순
        keyList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for(String key : keyList) {
            bw.write(key+"\n");
        }
        bw.flush();
    }
}