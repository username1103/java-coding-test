package BOJ;

import java.util.Scanner;

public class BOJ1439 {
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.next();

        int allOne = 0;
        int allZero = 0;

        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            allOne += 1;
        } else {
            allZero += 1;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (chars[i] == '0') {
                    allOne += 1;
                } else {
                    allZero += 1;
                }
            }
        }

        System.out.println(Math.min(allOne,allZero));
    }

}
