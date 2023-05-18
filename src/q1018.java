import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] inputs = new String[N];
        ArrayList<Integer> numbers = new ArrayList<>();
        String WB = "WBWBWBWB";
        String BW = "BWBWBWBW";

        // WB 입력
        for(int i=0; i<N; i++) {
            inputs[i] = sc.next();
        }

        for(int x=0; x<N-7; x++) {
            for(int y=0; y<M-7; y++) {
                int wbCount = 0;
                int bwCount = 0;
                for(int i=0; i<8; i++) { // 층수
                    for(int j=0; j<8; j++) { // 호수
                        //WB to BW => wbCount
                        if(i % 2 == 0) {
                            if(inputs[x+i].charAt(y+j) != WB.charAt(j)) wbCount++;
                        } else {
                            if(inputs[x+i].charAt(y+j) != BW.charAt(j)) wbCount++;
                        }

                        //BW to WB => bwCount
                        if(i % 2 == 0) {
                            if(inputs[x+i].charAt(y+j) != BW.charAt(j)) bwCount++;
                        } else {
                            if(inputs[x+i].charAt(y+j) != WB.charAt(j)) bwCount++;
                        }
                    }
                }
                numbers.add(Math.min(wbCount, bwCount));
            }
        }
        System.out.print(Collections.min(numbers));
    }
}
