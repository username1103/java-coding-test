package dynamic_programing;

import java.util.Scanner;
/*
input
3
output
5
 */
public class DP3 {

    static long[] memo;
    static int length;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        length = sc.nextInt();

        memo = new long[length + 1];

        memo[1] = 1;
        memo[2] = 3;

        for (int i = 3; i < length + 1; i++) {
            memo[i] = (memo[i-1] + memo[i-2] * 2) % 796796;
        }

        System.out.println(memo[length]);
    }
}
