import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        StringBuilder T = new StringBuilder(sc.next());

        while (S.length() < T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            } else {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        if (S.equals(T.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }
}