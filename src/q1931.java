import java.util.*;

public class q1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] conference = new int[N][2];
        for(int i=0; i<N; i++) {
            conference[i][0] = sc.nextInt();
            conference[i][1] = sc.nextInt();
        }

        Arrays.sort(conference, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int count = 0;
        int whattimeisit = 0;
        for(int i=0; i<conference.length; i++) {
            if(conference[i][0] >= whattimeisit) {
                count++;
                whattimeisit = conference[i][1];
            }
        }

        System.out.print(count);
    }
}
