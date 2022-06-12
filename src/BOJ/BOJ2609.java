package BOJ;

/*
유클리드 호제법 - gcd
gcd(a,b) * lcm(a,b) = a * b
 */

import java.util.Scanner;

public class BOJ2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int small = Math.min(a, b);
        int big = Math.max(a, b);

        int mod = big % small;
        while (mod > 0) {
            big = small;
            small = mod;
            mod = big % small;
        }

        int gcd = small;
        int lcm = a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);

    }
}
