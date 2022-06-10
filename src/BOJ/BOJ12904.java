package BOJ;

import java.util.Scanner;

public class BOJ12904 {
    static String S, T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextLine();
        T = sc.nextLine();


        while (T.length() != S.length()) {
            if(T.endsWith("B")) {
                T = removeLast(T);
                T = reverse(T);
            } else {
                T = removeLast(T);
            }
        }

        System.out.println(S.equals(T) ? 1 : 0);


    }

    public static String removeLast(String s) {
        return s.substring(0, s.length() - 1);
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
