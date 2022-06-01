package dynamic_programing;

import java.util.Scanner;
/*
input
4
1 3 1 5
output
8
 */
public class DP2 {
    static int count;

    static int[] d;

    static int[] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();

        d = new int[count];
        memo = new int[count];

        for (int i = 0; i < count; i++) {
            d[i] = sc.nextInt();
        }

        memo[0] = d[0];
        memo[1] = Math.max(d[0], d[1]);


        int result = getMaxValue(count - 1);

        System.out.println(result);
    }

    static int getMaxValue(int x) {
        if (x == 0) {
            return memo[0];
        }
        if (x == 1) {
            return memo[1];
        }
        if (memo[x] != 0) {
            return memo[x];
        }

        memo[x] = Math.max(getMaxValue(x - 2) + d[x], getMaxValue(x - 1));
        return memo[x];
    }
}
