package implement;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
input
K1KA5CB7
output
ABCKK13
input
AJKDLSI412K4JSJ9D
output
ADDIJJJKKLSS20
 */
public class implement5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        char[] chars = input.toCharArray();

        int[] alphabets = new int['Z' - 'A' + 1];

        int num = 0;
        for (char value : chars) {
            if ('0' <= value && value <= '9') {
                num += value - '0';
            } else {
                alphabets[value - 'A'] += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabets.length; i++) {

            for (int j = 0; j < alphabets[i]; j++) {
                sb.append((char) (i + 'A'));
            }

        }
        sb.append(num);

        System.out.print(sb);
    }
}
