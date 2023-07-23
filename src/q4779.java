import java.io.*;

public class q4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            // 0이 -, 1이 공백
            boolean[] line = new boolean[(int) Math.pow(3, N)];
            cantor(line, line.length, 0);

            for(int i=0; i<line.length; i++) {
                if(line[i]) bw.write(" "); // false면 -
                else bw.write("-"); // true면 공백
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void cantor(boolean[] line, int len, int s) {
        if(len != 1) {
            for(int i=s+(len/3*1); i<s+(len/3*2); i++) line[i] = true;

            cantor(line, len/3, s);
            cantor(line, len/3, s + len/3*2);
        }
    }
}
