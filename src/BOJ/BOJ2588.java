package BOJ;

import java.util.Scanner;

public class BOJ2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        sc.nextLine();
        String B = sc.nextLine();

        int temp1 = A * Integer.parseInt(B.substring(2));
        int temp2 = A * Integer.parseInt(B.substring(1, 2));
        int temp3 = A * Integer.parseInt(B.substring(0, 1));

        System.out.println(temp1);
        System.out.println(temp2);
        System.out.println(temp3);
        System.out.println(temp1 + (temp2 * 10) + (temp3 * 100));
    }
}
