import java.io.*;

public class q2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apart = new int[k+1][n];

            for(int num=0; num<n; num++) apart[0][num] = num+1;
            for(int floor=1; floor<k+1; floor++) {
                for(int num=0; num<n; num++) {
                    
                    // 맨 앞 호일 경우
                    if(num == 0) {
                        apart[floor][num] = 1;
                        continue;
                    }

                    int sum = 0;
                    for(int it=0; it<num+1; it++) {
                        sum += apart[floor-1][it];
                    }
                    apart[floor][num] = sum;
                }
            }
            bw.write(apart[k][n-1] + "\n");
        }
        bw.flush();
    }
}
