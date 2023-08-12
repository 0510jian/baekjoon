import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> S = new ArrayList<>();
        ArrayList<Integer> all = new ArrayList<>();
        for(int i=1; i<21; i++) all.add(i);

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            int v;
            switch(tk.nextToken()) {
                case "add" :
                    v = Integer.parseInt(tk.nextToken());
                    if(!S.contains(v)) S.add(v);
                    break;
                case "remove" :
                    v = Integer.parseInt(tk.nextToken());
                    if(S.contains(v)) S.remove(new Integer(v));
                    break;
                case "check" :
                    v = Integer.parseInt(tk.nextToken());
                    if(S.contains(v)) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "toggle" :
                    v = Integer.parseInt(tk.nextToken());
                    if(S.contains(v)) S.remove(new Integer(v));
                    else S.add(v);
                    break;
                case "all" :
                    S = (ArrayList<Integer>) all.clone();
                    break;
                case "empty" :
                    S.clear();
            }
        }
        bw.flush();
    }
}
