package BOJ;

import java.util.Scanner;

public class BOJ18406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        char[] chars = input.toCharArray();

        int before = 0;
        int after = 0;

        for (int i = 0; i < chars.length / 2; i++) {
            before += chars[i] - '0';
            after += chars[chars.length / 2 + i] - '0';
        }

        System.out.println(before == after ? "LUCKY" : "READY");
    }
}
