package BOJ;

import java.util.Scanner;

public class BOJ10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int cur = sc.nextInt();

            max = Math.max(cur, max);
            min = Math.min(cur, min);
        }

        System.out.println(min + " " + max);
    }
}
