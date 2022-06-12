package BOJ;

import java.util.Scanner;

public class BOJ2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int value = 1;
        for (int i = 0; i < 3; i++) {
            value *= sc.nextInt();
        }

        int[] counts = new int[10];

        String valueString = Integer.toString(value);

        for (char val : valueString.toCharArray()) {
            counts[val - '0'] += 1;
        }

        for (int count : counts) {
            System.out.println(count);
        }
    }
}
