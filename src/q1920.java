import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] listN = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(listN);

        int M = Integer.parseInt(br.readLine());
        int[] listM = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int m : listM)
            bw.write(binarySearch(listN, m) + "\n");

        bw.flush();
    }

    public static int binarySearch(int[] list, int value) {
        int start = 0;
        int end = list.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(list[mid] > value) end = mid - 1;
            else if(list[mid] < value) start = mid + 1;
            else return 1;
        }
        return 0;
    }
}
