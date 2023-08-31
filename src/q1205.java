import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class q1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int T = Integer.parseInt(tk.nextToken()); // 태수의 새로운 점수
        int P = Integer.parseInt(tk.nextToken());

        if(N == 0) {
            System.out.print(1);
            return;
        }

        int[] Ps = new int[P];
        int[] PsRank = new int[P];
        Arrays.fill(Ps, -1);
        if(N > 0) {
            Integer[] score = new Integer[N];
            tk = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N; i++) score[i] = Integer.parseInt(tk.nextToken());
            Arrays.sort(score, Collections.reverseOrder());

            for(int i=0; i<N; i++) Ps[i] = score[i];
        }

        int countRank = 0;
        for(int i=0; i<Ps.length; i++) {
            boolean isT = false;
            ++countRank;

            // T가 들어갈 자리 확인
            if(Ps[i] == -1 || Ps[i] < T) {
                Ps[i] = T;
                isT = true;
            }

            // 등수 매기기
            if(i == 0) PsRank[i] = countRank;
            else {
                if(Ps[i-1] == Ps[i]) PsRank[i] = PsRank[i-1];
                else PsRank[i] = countRank;
            }

            // T일 경우 종료
            if(isT) {
                System.out.print(PsRank[i]);
                return;
            }
        }

        System.out.print(-1);
    }
}
