package BOJ;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2407 {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        BigInteger result = new BigInteger("1");
        BigInteger divide = new BigInteger("1");
        if (m > n / 2) {
            m = n - m;
        }

        for (int i = 0; i < m; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));
        }

        for (int i = 1; i <= m; i++) {
            divide = divide.multiply(BigInteger.valueOf(i));
        }


        System.out.println(result.divide(divide));
    }
}
