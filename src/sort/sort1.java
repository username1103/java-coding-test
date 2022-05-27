package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/*
input
3
15
27
12
output
27 15 12
 */
public class sort1 {
    static int count;

    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());

        a = new int[count];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();

        for (int j = a.length - 1; j >= 0; j--) {
            sb.append(a[j]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
