import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class q2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // true가 공백, false가 별
        boolean[][] stars = new boolean[N][N];

        cutStar(stars, 0, 0, N);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(stars[i][j]) bw.write(" ");
                else bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void cutStar(boolean[][] stars, int startY, int startX, int len) {
        if(len != 1) {
            for(int i=startY + len/3; i<startY+len/3*2; i++) {
                for(int j=startX + len/3; j<startX+len/3*2; j++) {
                    stars[i][j] = true;
                }
            }

            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    cutStar(stars, startY + len/3*i, startX+len/3*j, len/3);
                }
            }
        }
    }
}
