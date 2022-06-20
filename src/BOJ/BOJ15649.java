package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15649 {

    static ArrayList<int[]> arr = new ArrayList<>();
    static boolean[] visited;
    static int[] values;

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
        process(values, n, r, 0, result);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).length; j++) {
                System.out.print(arr.get(i)[j] + " ");
            }
            System.out.println();
        }
    }

    public static void process(int[] values, int n, int r, int depth, int[] result) {
        if (depth == r) {
            arr.add(result.clone());
            return;
        }


        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            result[depth] = values[i];
            process(values, n, r, depth + 1, result);
            visited[i] = false;
        }
    }
}
