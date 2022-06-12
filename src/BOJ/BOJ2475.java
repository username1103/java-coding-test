package BOJ;

import java.util.Scanner;

public class BOJ2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += Math.pow(sc.nextInt(), 2);
        }

        System.out.println(total % 10);
    }
}
