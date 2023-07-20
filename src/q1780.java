import java.io.*;

public class q1780 {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 영상 입력
        int[][] screen = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                screen[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 쿼드 트리 시작
        quadTree(screen, N, 0, 0, bw);
        bw.write(minus + "\n" + zero + "\n" + plus);

        bw.flush();
    }

    public static void quadTree(int[][] screen, int size, int startA, int startB, BufferedWriter bw) throws IOException {
        // A가 세로(층), B가 가로(호)

        // size가 1인 경우
        if(size == 1) {
            if(screen[startA][startB] == -1) minus++;
            else if(screen[startA][startB] == 1) plus++;
            else zero++;
        }
        // size가 1이 아닌 경우
        else {
            int tempMinus = 0, tempZero = 0, tempPlus = 0;
            for(int i=startA; i<startA+size; i++) {
                for(int j=startB; j<startB+size; j++) {
                    if(screen[i][j] == -1) tempMinus++;
                    else if(screen[i][j] == 1) tempPlus++;
                    else tempZero++;
                }
            }

            // 값이 하나가 아닌 경우
            if((tempPlus != 0 && tempMinus != 0) || (tempPlus != 0 && tempZero != 0) || (tempMinus != 0 && tempZero != 0)) {
                for(int a=0; a<3; a++) {
                    for(int b=0; b<3; b++) {
                        quadTree(screen, size/3, startA + a*(size/3), startB + b*(size/3), bw);
                    }
                }
            }
            // 값이 하나인 경우
            else {
                if(screen[startA][startB] == -1) minus++;
                else if(screen[startA][startB] == 1) plus++;
                else zero++;
            }
        }
    }
}
