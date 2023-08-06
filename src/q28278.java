import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class q28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> stack = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String command = br.readLine();

            if(command.length() < 2) {
                switch(command) {
                    case "2" :
                        if(stack.isEmpty()) bw.write("-1\n");
                        else {
                            bw.write(stack.get(stack.size()-1)+"\n");
                            stack.remove(stack.size()-1);
                        }
                        break;
                    case "3" :
                        bw.write(stack.size()+"\n");
                        break;
                    case "4" :
                        if(stack.isEmpty()) bw.write("1\n");
                        else bw.write("0\n");
                        break;
                    case "5" :
                        if(stack.isEmpty()) bw.write("-1\n");
                        else bw.write(stack.get(stack.size()-1)+"\n");
                }
            } else {
                String[] split = command.split(" ");
                stack.add(Integer.parseInt(split[1]));
            }
        }

        bw.flush();
    }
}
