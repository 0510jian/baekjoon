import java.io.*;
import java.util.*;

public class q28256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int a=0; a<T; a++) {
            // 박스 채우기
            String[][] array = new String[3][3];
            for(int i=0; i<3; i++) {
                String[] S = br.readLine().split("");
                for(int j=0; j<3; j++) {
                    array[i][j] = S[j];
                }
            }

            // 원형 boolean 생성
            boolean[] box = new boolean[8];
            box[0] = array[0][0].equals("O") ? true : false;
            box[1] = array[0][1].equals("O") ? true : false;
            box[2] = array[0][2].equals("O") ? true : false;
            box[3] = array[1][2].equals("O") ? true : false;
            box[4] = array[2][2].equals("O") ? true : false;
            box[5] = array[2][1].equals("O") ? true : false;
            box[6] = array[2][0].equals("O") ? true : false;
            box[7] = array[1][0].equals("O") ? true : false;

            // 연속 초콜릿 구하기
            ArrayList<Integer> chocolate = new ArrayList<>();
            int count = 0;
            for(int i=0; i<box.length; i++) {
                if(box[i]) count++;

                if((!box[i] && count > 0) || (box[i] && i==box.length-1)) {
                    if(chocolate.isEmpty() && count == 8) {
                        chocolate.add(count);
                        break;
                    }
                    if(box[0] && box[i] && i == box.length-1) {
                        chocolate.set(0, chocolate.get(0) + count);
                        break;
                    }
                    chocolate.add(count);
                    count = 0;
                }
            }
            Collections.sort(chocolate);

            // 상태 입력
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());

            if(N == 0 && chocolate.size() == 0) {
                bw.write("1\n");
                continue;
            } else if(N == 0 && chocolate.size() != 0) {
                bw.write("0\n");
                continue;
            }

            int[] input = new int[N];
            for(int i=0; i<N; i++) {
                input[i] = Integer.parseInt(tk.nextToken());
            }
            Arrays.sort(input);

            // 비교 후 결과 출력
            boolean equal = true;
            if(input.length != chocolate.size()) {
                bw.write("0\n");
            } else {
                for(int i=0; i<input.length; i++) {

                    if(input[i] != chocolate.get(i)) equal = false;
                }
                if(equal) bw.write("1\n");
                else bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
