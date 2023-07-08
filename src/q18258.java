import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class q18258 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[N];
        int startIndex = 0;
        int endIndex = -1;

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            switch(input[0]) {
                case "push" :
                    queue[++endIndex] = Integer.parseInt(input[1]);
                    break;

                case "pop" :
                    if(startIndex > endIndex) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue[startIndex++]+"\n");
                    }
                    break;

                case "size" :
                    bw.write(endIndex - startIndex + 1 +"\n");
                    break;

                case "empty" :
                    if (startIndex > endIndex) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;

                case "front" :
                    if(startIndex > endIndex) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue[startIndex]+"\n");
                    }
                    break;

                case "back" :
                    if(startIndex > endIndex) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue[endIndex]+"\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}
