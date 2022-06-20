package BOJ;

import java.util.*;

public class BOJ15666 {

    static boolean[] visited;
    static int[] values;

    static Set<String> s = new LinkedHashSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        values = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Arrays.sort(values);

        process(values, n, r, 0, 0, "");


        for (String a : s) {
            System.out.println(a);
        }

    }

    public static void process(int[] values, int n, int r, int depth, int index, String result) {
        if (depth == r) {
            s.add(result);
            return;
        }


        for (int i = index; i < n; i++) {
            process(values, n, r, depth + 1, i,result + values[i] + " ");
        }
    }
}


