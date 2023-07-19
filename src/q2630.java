import java.util.Scanner;

public class q2630 {
    static int countW = 0, countB = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[][] paper = new boolean[N][N];

        // 색종이 색 입력
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int temp = sc.nextInt();
                if(temp == 1) paper[i][j] = true;
            }
        }

        cut(paper, N, 0, 0);

        System.out.println(countW + "\n" + countB);
    }

    public static void cut(boolean[][] paper, int size, int startX, int startY) {
        //System.out.println("!!!" + startX + " - " + startY);
        // 사이즈가 1이 아닐 경우
        if(size != 1) {
            // 전체 WB 체크
            int tempW = 0, tempB = 0;
            for(int i=startX; i<startX+size; i++) {
                for(int j=startY; j<startY+size; j++) {
                    if(paper[i][j]) tempB++;
                    else tempW++;
                }
            }

            // 일괄이 아닐 경우 4등분하여 재귀 시작
            if(tempW != 0 && tempB != 0) {
                for(int a=0; a<2; a++) {
                    for(int b=0; b<2; b++) {
                        cut(paper, size/2, startX + a*(size/2), startY + b*(size/2));
                    }
                }
            }

            // 일괄일 경우(모두 1 or 모두 0)
            else {
                if(tempW == 0) countB++;
                else countW++;

                return;
            }
        }
        
        // 사이즈가 1일 경우
        if(size == 1) {
            if(paper[startX][startY]) countB++;
            else countW++;

            return;
        }
    }
}
