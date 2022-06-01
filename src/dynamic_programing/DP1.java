package dynamic_programing;

import java.util.Arrays;
import java.util.Scanner;

public class DP1 {
    static int[] d = new int[30001];

    public static void main(String[] args) {
        d[1] = 0;
        d[2] = 1;
        d[3] = 1;
        d[5] = 1;

        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();

        for (int i = 4; i <= target; i++) {

            d[i] = d[i - 1] + 1;

            if (i % 5 == 0) {
                d[i] = Math.min(d[i / 5] + 1, d[i]);
            }
            if (i % 3 == 0) {
                d[i] = Math.min(d[i / 3] + 1, d[i]);
            }
            if (i % 2 == 0) {
                d[i] = Math.min(d[i / 2] + 1, d[i]);
            }

        }

        System.out.println(d[target]);
    }
}
