import java.io.*;

public class q1992 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 영상 입력
        int[][] screen = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++) {
                screen[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 쿼드 트리 시작
        quadTree(screen, N, 0, 0, bw);

        bw.flush();
    }

    public static void quadTree(int[][] screen, int size, int startA, int startB, BufferedWriter bw) throws IOException {
        // A가 세로(층), B가 가로(호)

        // size가 1인 경우
        if(size == 1) {
            if(screen[startA][startB] == 1) bw.write("1");
            else bw.write("0");
        }
        // size가 1이 아닌 경우
        else {
            int temp1 = 0, temp0 = 0;
            for(int i=startA; i<startA+size; i++) {
                for(int j=startB; j<startB+size; j++) {
                    if(screen[i][j] == 0) temp0++;
                    else temp1++;
                }
            }
            
            // 값이 하나가 아닌 경우
            if(temp0 != 0 && temp1 != 0) {
                bw.write("(");
                for(int a=0; a<2; a++) {
                    for(int b=0; b<2; b++) {
                        quadTree(screen, size/2, startA + a*(size/2), startB + b*(size/2), bw);
                    }
                }
                bw.write(")");
            }
            // 값이 하나인 경우
            else {
                if(temp0 == 0) bw.write("1");
                else bw.write("0");
            }
        }
    }
}
