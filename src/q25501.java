import java.util.Scanner;

public class q25501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for(int i=0; i<T; i++) {
            String input = sc.nextLine();
            isPalindrome(input);
        }
    }

    public static int recursion(String s, int l, int r, int count){
        if(l >= r) {
            System.out.println("1 " + count);
            return 0;
        }
        else if(s.charAt(l) != s.charAt(r)) {
            System.out.println("0 " + count);
            return 0;
        }
        else return recursion(s, l+1, r-1, ++count);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1, 1);
    }
}
