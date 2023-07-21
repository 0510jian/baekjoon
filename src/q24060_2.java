import java.io.*;

public class q24060_2 {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] list = new int[N];
        int[] tmp = new int[list.length];
        input = br.readLine().split(" ");
        for(int i=0; i<list.length; i++) list[i] = Integer.parseInt(input[i]);

        merge_sort(list, 0, list.length-1, tmp, K, bw);

        bw.write("-1");
        bw.flush();
    }

    public static void merge_sort(int[] list, int p, int r, int[] tmp, int K, BufferedWriter bw) throws IOException {
        if(p < r) {
            int q = (p + r) / 2;
            merge_sort(list, p, q, tmp, K, bw);
            merge_sort(list, q+1, r, tmp, K, bw);
            merge(list, p, q, r, tmp, K, bw);
        }
    }

    public static void merge(int[] list, int p, int q, int r, int[] tmp, int K, BufferedWriter bw) throws IOException {
        int i=p, j=q+1, t=0;

        while(i <= q && j <= r) {
            if(list[i] <= list[j]) {
                tmp[t++] = list[i++];
            } else {
                tmp[t++] = list[j++];
            }
        }
        while(i <= q) tmp[t++] = list[i++];
        while(j <= r) tmp[t++] = list[j++];
        i = p;
        t = 0;
        while(i <= r) {
            if(++count == K) {
                bw.write(tmp[t] + "");
                bw.flush();
                System.exit(0);
            }
            list[i++] = tmp[t++];
        }
    }
}
