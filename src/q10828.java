import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class q10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            switch(input[0]) {
                case "push" :
                    stack.add(Integer.parseInt(input[1]));
                    break;
                case "pop" :
                    if(stack.size() <= 0) bw.write(-1+"\n");
                    else {
                        bw.write(stack.get(stack.size()-1)+"\n");
                        stack.remove(stack.size()-1);
                    }
                    break;
                case "size":
                    bw.write(stack.size()+"\n");
                    break;
                case "empty" :
                    if(stack.size() > 0) bw.write(0+"\n");
                    else bw.write(1+"\n");
                    break;
                case "top" :
                    if(stack.size() <= 0) bw.write(-1+"\n");
                    else bw.write(stack.get(stack.size()-1)+"\n");
                    break;
            }
        }
        bw.flush();
    }
}
