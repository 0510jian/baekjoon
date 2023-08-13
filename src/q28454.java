import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class q28454 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = formatter.parse(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<N; i++) {
            Date date = formatter.parse(br.readLine());
            if (date.after(currentDate) || date.equals(currentDate)) count++;
        }

        bw.write(count+"");
        bw.flush();
    }
}
