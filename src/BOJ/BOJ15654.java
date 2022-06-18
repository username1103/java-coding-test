package BOJ;

import java.util.*;

public class BOJ15654 {
    static class Permutation {
        int n, r;
        int[] now;
        ArrayList<int[]> results;

        public Permutation(int n, int r) {
            this.n = n;
            this.r = r;
            this.now = new int[r];
            this.results = new ArrayList<>();
        }

        public void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        public void permutation(int[] arr, int depth) {
            if (depth == r) {
                results.add(now.clone());
                return;
            }

            for (int i = depth; i < arr.length; i++) {
                swap(arr, depth, i);
                now[depth] = arr[depth];
                permutation(arr, depth + 1);
                swap(arr, depth, i);
            }
        }
    }

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Permutation perm = new Permutation(values.length, m);
        perm.permutation(values, 0);

        perm.results.sort((o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] == o2[i]) continue;
                else if (o1[i] < o2[i]) return -1;
                else return 1;
            }
            return 1;
        });

        for (int[] result : perm.results) {
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
