package BOJ;

import java.util.Scanner;

public class BOJ2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        String s = "";

        for (int i = 0; i < max; i++) {
            s += "*";
            System.out.println(s);
        }
    }
}
