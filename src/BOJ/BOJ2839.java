package BOJ;

import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] values = new int[5001];

        values[1] = -1;
        values[2] = -1;
        values[3] = 1;
        values[4] = -1;
        values[5] = 1;


        for (int i = 5; i <= n; i++) {
            int before3 = values[i - 3];
            int before5 = values[i - 5];

            if (before5 < 0 && before3 < 0) {
                values[i] = -1;
            } else if (before5 < 0) {
                values[i] = before3 + 1;
            } else if (before3 < 0) {
                values[i] = before5 + 1;
            } else {
                values[i] = Math.min(before3, before5) + 1;
            }
        }

        System.out.println(values[n]);
    }
}
