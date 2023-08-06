import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class q28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String command = br.readLine();

            if(command.length() > 2) {
                String[] split = command.split(" ");
                switch(split[0]) {
                    case "1" :
                        deque.addFirst(Integer.parseInt(split[1]));
                        break;
                    case "2" :
                        deque.addLast(Integer.parseInt(split[1]));
                }
            } else {
                switch(command) {
                    case "3" :
                        if(deque.isEmpty()) bw.write("-1\n");
                        else bw.write(deque.pollFirst() + "\n");
                        break;
                    case "4" :
                        if(deque.isEmpty()) bw.write("-1\n");
                        else bw.write(deque.pollLast() + "\n");
                        break;
                    case "5" :
                        bw.write(deque.size() + "\n");
                        break;
                    case "6" :
                        if(deque.isEmpty()) bw.write("1\n");
                        else bw.write("0\n");
                        break;
                    case "7" :
                        if(deque.isEmpty()) bw.write("-1\n");
                        else bw.write(deque.getFirst() + "\n");
                        break;
                    case "8" :
                        if(deque.isEmpty()) bw.write("-1\n");
                        else bw.write(deque.getLast() + "\n");
                }
            }
        }
        bw.flush();
    }
}
