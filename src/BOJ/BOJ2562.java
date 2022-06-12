package BOJ;

import java.util.Scanner;

public class BOJ2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < 9; i++) {
            int input = sc.nextInt();
            if (input > max) {
                max = input;
                maxIdx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(maxIdx);
    }
}
