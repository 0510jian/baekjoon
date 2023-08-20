import java.util.Scanner;

public class q28255 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for(int i=0; i<T; i++) {
            String S = sc.nextLine();
            String dashS = S.substring(0, (int)Math.ceil(S.length()/3.0));

            String rev = rev(dashS);
            String tail = tail(dashS);
            String tailrev = tail(rev(dashS));

            if(S.equals(dashS + rev + dashS) || S.equals(dashS + tailrev + dashS) || S.equals(dashS + rev + tail) || S.equals(dashS + tailrev + tail)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static String rev(String s) {
        String result = "";
        for(int i=s.length()-1; i>=0; i--) result += String.valueOf(s.charAt(i));
        return result;
    }

    public static String tail(String s) {
        return s.substring(1, s.length());
    }
}
