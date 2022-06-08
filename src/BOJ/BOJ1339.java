package BOJ;

import java.util.*;

public class BOJ1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        long[] alphabets = new long['Z' - 'A' + 1];
        for (int i = 0; i < n; i++) {
            char[] inputs = sc.nextLine().toCharArray();
            for (int j = 0; j < inputs.length; j++) {
                int cur = inputs[j] - 'A';
                alphabets[cur] += Math.pow(10, inputs.length - j - 1);
            }
        }
        Arrays.sort(alphabets);

        int result = 0;
        for (int i = 0; i < alphabets.length; i++) {
            result += alphabets[alphabets.length - i - 1] * (9 - i);
        }

        System.out.println(result);


    }
}
