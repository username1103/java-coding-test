package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2740 행렬곱셈
 */
public class BOJ2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int oneRowLength = Integer.parseInt(st.nextToken());
        int oneColLength = Integer.parseInt(st.nextToken());
        int[][] a = new int[oneRowLength][oneColLength];
        for (int i = 0; i < oneRowLength; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                a[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int twoRowLength = Integer.parseInt(st.nextToken());
        int twoColLength = Integer.parseInt(st.nextToken());
        int[][] b = new int[twoRowLength][twoColLength];
        for (int i = 0; i < twoRowLength; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                b[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        int[][] result = new int[oneRowLength][twoColLength];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < oneRowLength; i++) {
            int[] aRow = a[i];
            for (int j = 0; j < twoColLength; j++) {
                for (int o = 0; o < aRow.length; o++) {
                    result[i][j] += aRow[o] * b[o][j];
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


}
