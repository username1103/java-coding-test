package BOJ;

import java.util.Scanner;

public class BOJ9251 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String one = sc.nextLine();
        String two = sc.nextLine();

        int[][] t = new int[one.length() + 1][two.length() + 1];

        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < two.length(); j++) {
                int a = one.charAt(i);
                int b = two.charAt(j);

                if (a == b) {
                    t[i + 1][j + 1] = t[i][j] + 1;
                } else {
                    t[i + 1][j + 1] = Math.max(t[i][j + 1], t[i + 1][j]);
                }
            }
        }

        System.out.println(t[one.length()][two.length()]);

    }
}
