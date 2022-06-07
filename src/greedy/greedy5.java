package greedy;

import java.util.Scanner;

/*
input
02984
output
576
input
567
output
210
 */
public class greedy5 {
    static char[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = sc.next().toCharArray();


        int result = input[0] - '0';
        for (int i = 1; i < input.length; i++) {
            int val = input[i] - '0';
            if (val <= 1 || result <= 1) {
                result += val;
            } else {
                result *= val;
            }

        }
        System.out.println(result);

    }
}
