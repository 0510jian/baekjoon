import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[tk.countTokens()];
        int countToken = tk.countTokens();
        for(int i=0; i<countToken; i++) numbers[i] = Integer.parseInt(tk.nextToken());
        Arrays.sort(numbers);

        int target = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) count++;
                if(numbers[i] + numbers[j] >= target) break;
            }
        }

        bw.write(count+"");
        bw.flush();
    }
}
