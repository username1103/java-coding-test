package BOJ;

import java.util.Scanner;

public class BOJ11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] value = new int[n];
        int[] d = new int[n];

        int result = 1;
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
            d[i] = 1;


            for (int j = i - 1; j >= 0; j--) {
                if (value[j] < value[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                    result = Math.max(result, d[i]);
                }
            }
        }
        System.out.println(result);
    }
}
