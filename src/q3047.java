import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class q3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 3;

        // 수 정렬
        String[] splitNum = br.readLine().split(" ");
        int[] numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(splitNum[i]);
        }
        Arrays.sort(numbers);

        // 해시 맵
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            map.put((char)((int)'A' + i), numbers[i]);
        }

        // 결과 출력
        String[] splitAlpha = br.readLine().split("");
        for(int i=0; i<N; i++) {
            System.out.print(map.get(splitAlpha[i].charAt(0)) + " ");
        }
    }
}
