import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q10866 {

    public static class deque {
        int front;
        int rear;
        int count = 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] deque = new int[N*3];

        int front = N;
        int rear = front-1;
        int size = 0;

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            switch(input[0]) {
                case "push_front" :
                    if(size > 0) {
                        deque[front-1] = Integer.parseInt(input[1]);
                        size++;
                        front--;
                    } else {
                        deque[front] = Integer.parseInt(input[1]);
                        size++;
                        rear++;
                    }
                    break;
                case "push_back" :
                    if(size > 0) {
                        deque[rear+1] = Integer.parseInt(input[1]);
                        size++;
                        rear++;
                    } else {
                        deque[front] = Integer.parseInt(input[1]);
                        size++;
                        rear++;
                    }
                    break;
                case "pop_front" :
                    if(size > 0) {
                        bw.write(deque[front]+"\n");
                        front++;
                        size--;
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "pop_back" :
                    if(size > 0) {
                        bw.write(deque[rear] + "\n");
                        rear--;
                        size--;
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size" :
                    bw.write(size+"\n");
                    break;
                case "empty" :
                    if(size > 0) {
                        bw.write("0\n");
                    } else {
                        bw.write("1\n");
                    }
                    break;
                case "front" :
                    if(size > 0) {
                        bw.write(deque[front]+"\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "back" :
                    if(size > 0) {
                        bw.write(deque[rear] + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
            }
        }
        bw.flush();
    }


}
