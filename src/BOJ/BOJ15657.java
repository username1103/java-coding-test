package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        int[] values = new int[n];
        int[] results = new int[r];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Arrays.sort(values);

        process(values, results, 0, 0, n, r);
    }

    public static void process(int[] values, int[] result, int start, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.print("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            result[depth] = values[i];
            process(values, result, i, depth + 1, n, r);
        }

    }
}
