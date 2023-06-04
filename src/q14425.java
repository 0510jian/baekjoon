import java.io.*;
import java.util.ArrayList;

public class q14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] counts = br.readLine().split(" ");
        ArrayList<String> inputsN = new ArrayList<>();
        ArrayList<String> inputsM = new ArrayList<>();
        int count = 0;
        for(int i=0; i<Integer.parseInt(counts[0]); i++)
            inputsN.add(br.readLine());
        for(int i=0; i<Integer.parseInt(counts[1]); i++)
            inputsM.add(br.readLine());

        for(int i=0; i<inputsM.size(); i++)
            if(inputsN.contains(inputsM.get(i))) count++;

        bw.write(count+"");
        bw.flush();
    }
}
