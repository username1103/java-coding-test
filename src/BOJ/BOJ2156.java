package BOJ;

import java.util.Scanner;

/**
 * BOJ2156 포도주 시식
 */
public class BOJ2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] values = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                d[i] = values[i];
            } else if (i == 1) {
                d[i] = values[i] + d[0];
            } else if (i == 2) {
                d[i] = Math.max(Math.max(values[0] + values[i], values[1] + values[i]), d[i - 1]);
            } else {
                d[i] = Math.max(Math.max(d[i - 2], d[i - 3] + values[i - 1]) + values[i], d[i - 1]);
            }
        }

        System.out.println(d[n - 1]);
    }
}
