package BOJ;

import java.util.Scanner;

public class BOJ11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] values = new int[n];
        int[] d1 = new int[n];
        int[] d2 = new int[n];


        // 1. LIS 를 양쪽에서 진행
        // 2. 두 LIS 값의 최대값을 구하여 겹치는 값을 빼어줌 (-1)
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();

            d1[i] = 1;

            for (int j = 0; j < i; j++) {
                if (values[j] < values[i]) {
                    d1[i] = Math.max(d1[j] + 1, d1[i]);
                }
            }
        }

        for (int i = values.length - 1; i >= 0; i--) {
            d2[i] = 1;

            for (int j = values.length - 1; j > i; j--) {
                if (values[j] < values[i]) {
                    d2[i] = Math.max(d2[j] + 1, d2[i]);
                }
            }
        }


        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(d1[i] + d2[i], result);
        }


        System.out.println(result - 1);
    }
}
