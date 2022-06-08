package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class greedy6 {
    static int n;
    static int[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        int target = 1;
        for (int coin : coins) {
            if (target < coin) {
                break;
            }
            target += coin;
        }

        System.out.println(target);
    }


}
