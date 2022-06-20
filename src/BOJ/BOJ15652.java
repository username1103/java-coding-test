package BOJ;

import java.util.Scanner;

public class BOJ15652 {

    static boolean[] visited;
    static int[] values;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        values = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            values[i] = i + 1;
        }

        int[] result = new int[r];
        process(values, n, r, 0,0, result);


        System.out.println(sb);
    }

    public static void process(int[] values, int n, int r, int depth,int index, int[] result) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = index; i < n; i++) {
            result[depth] = values[i];
            process(values, n, r, depth + 1,i, result);

        }
    }
}


