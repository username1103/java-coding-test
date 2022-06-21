package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        int result = -1;
        for (int i = 0; i < values.length - 2; i++) {
            int one = values[values.length - i - 1];
            int two = values[values.length - i - 2];
            int three = values[values.length - i - 3];

            if (two + three > one) {
                result = one + two + three;
                break;
            }
        }

        System.out.println(result);
    }
}
