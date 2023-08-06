import java.io.*;
import java.util.*;

public class q12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> waitingLine = new ArrayList<>();
        Stack<Integer> alley = new Stack<>();

        // 스타팅 줄
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) waitingLine.add(Integer.parseInt(tk.nextToken()));

        // 골목길 진입(뒤에 있는 사람들보다 한 명이라도 값이 클 경우)
        int get = 0;
        while(true) {
            // 대기줄과 골목이 모두 비었을 때 Nice
            if(waitingLine.isEmpty() && alley.empty()) {
                bw.write("Nice");
                bw.flush();
                return;
            }

            // 대기줄에만 사람이 있을 경우
            if(!waitingLine.isEmpty() && alley.empty()) {
                int me = waitingLine.get(0);
                waitingLine.remove(0);
                
                boolean goAlley = false;
                // waitingLine에 me보다 작은 값이 있을 경우 me를 alley에 추가
                for(int i=0; i<waitingLine.size(); i++) {
                    if(me > waitingLine.get(i)) {
                        alley.push(me);
                        goAlley = true;
                        break;
                    }
                }
                
                // 바로 간식을 받을 경우
                if(!goAlley) {
                    if(get < me) get = me;
                    // get(이미 받은 사람 번호)보다 me가 더 작으면 순서가 맞지 않으므로 Sad 처리
                    else {
                        bw.write("Sad");
                        bw.flush();
                        return;
                    }
                }
            }
            // 골목에만 사람이 있을 경우
            else if(waitingLine.isEmpty() && !alley.empty()) {
                int me = alley.pop();

                if(get < me) get = me;
                // get(이미 받은 사람 번호)보다 me가 더 작으면 순서가 맞지 않으므로 Sad 처리
                else {
                    bw.write("Sad");
                    bw.flush();
                    return;
                }
            }
            // 대기줄 + 골목길 모두 사람이 있을 경우
            else {
                // 만약 alley가 waitingLine보다 작을 경우
                if(alley.get(alley.size()-1) < waitingLine.get(0)) {
                    int me = alley.pop();

                    if(get < me) get = me;
                        // get(이미 받은 사람 번호)보다 me가 더 작으면 순서가 맞지 않으므로 Sad 처리
                    else {
                        bw.write("Sad");
                        bw.flush();
                        return;
                    }
                }
                // 작지 않을 경우 => 대기줄에만 사람이 있을 경우 와 동일하게 진행
                else {
                    int me = waitingLine.get(0);
                    waitingLine.remove(0);

                    boolean goAlley = false;
                    // waitingLine에 me보다 작은 값이 있을 경우 me를 alley에 추가
                    for(int i=0; i<waitingLine.size(); i++) {
                        if(me > waitingLine.get(i)) {
                            alley.push(me);
                            goAlley = true;
                            break;
                        }
                    }

                    // 바로 간식을 받을 경우
                    if(!goAlley) {
                        if(get < me) get = me;
                            // get(이미 받은 사람 번호)보다 me가 더 작으면 순서가 맞지 않으므로 Sad 처리
                        else {
                            bw.write("Sad");
                            bw.flush();
                            return;
                        }
                    }
                }
            }
        }
    }
}
