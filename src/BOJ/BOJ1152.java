package BOJ;

import java.util.Scanner;

public class BOJ1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] result = sc.nextLine().trim().split(" ");


        System.out.println(result[0] == "" ? 0 : result.length);
    }
}
