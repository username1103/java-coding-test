package dynamic_programing;

import java.util.Arrays;
import java.util.Scanner;
/*
input
2 15
2
3
output
5
input
3 4
3
5
7
output
-1
 */
public class DP4 {
    static int count;
    static int target;

    static int[] coins;
    static int[] values;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        target = sc.nextInt();

        coins = new int[count];
        values = new int[target + 1];
        Arrays.fill(values, 10001);
        values[0] = 0;

        for (int i = 0; i < count; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = 0; i <= target; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    values[i] = Math.min(values[i - coin] + 1, values[i]);
                }
            }
        }

        int result = values[target];
        if (result == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }
}
