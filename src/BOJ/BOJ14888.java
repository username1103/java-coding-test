package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ14888 {

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

        public void permutation(int[] arr, int depth) {
            if (depth == r) {
                int[] temp = new int[r];
                for (int i = 0; i < now.length; i++) {
                    temp[i] = now[i];
                }
                results.add(temp);
                return;
            }

            for (int i = depth; i < n; i++) {
                swap(arr, depth, i);
                now[depth] = arr[depth];
                permutation(arr, depth + 1);
                swap(arr, depth, i);
            }
        }

        public void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    static int n;
    static int[] values;

    static int[] operations;

    static int min = (int) 10e9;
    static int max = (int) 10e9 * -1;

    static int plusCount;
    static int minusCount;
    static int mulCount;
    static int divCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        values = new int[n];
        operations = new int[n - 1];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        plusCount = sc.nextInt();
        minusCount = sc.nextInt();
        mulCount = sc.nextInt();
        divCount = sc.nextInt();
//        for (int i = 0; i < plusCount; i++) {
//            operations[i] = '+';
//        }
//        for (int i = plusCount; i <plusCount + minusCount ; i++) {
//            operations[i] = '-';
//        }
//        for (int i = plusCount + minusCount; i < plusCount + minusCount + mulCount; i++) {
//            operations[i] = '*';
//        }
//        for (int i = plusCount+minusCount+mulCount; i <plusCount+minusCount+mulCount+divCount ; i++) {
//            operations[i] = '/';
//        }
//
//        Permutation perm = new Permutation(operations.length, operations.length);
//        perm.permutation(operations, 0);


//        for (int i = 0; i < perm.results.size(); i++) {
//            int[] result = perm.results.get(i);
//            int temp = values[0];
//            for (int j = 0; j < result.length; j++) {
//                int operation = result[j];
//                switch(operation){
//                    case '+':
//                        temp += values[j + 1];
//                        break;
//                    case '-':
//                        temp -= values[j + 1];
//                        break;
//                    case '*':
//                        temp *= values[j + 1];
//                        break;
//                    case '/':
//                        temp /= values[j + 1];
//                        break;
//                }
//            }
//            max = Math.max(max, temp);
//            min = Math.min(min, temp);
//        }

        dfs(1, values[0]);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int i, int now) {
        if (i == n) {
            min = Math.min(min, now);
            max = Math.max(max, now);
        } else {
            if (plusCount > 0) {
                plusCount -= 1;
                dfs(i + 1, now + values[i]);
                plusCount += 1;
            }
            if (minusCount > 0) {
                minusCount -= 1;
                dfs(i + 1, now - values[i]);
                minusCount += 1;
            }
            if (mulCount > 0) {
                mulCount -= 1;
                dfs(i + 1, now * values[i]);
                mulCount += 1;
            }
            if (divCount > 0) {
                divCount -= 1;
                dfs(i + 1, now / values[i]);
                divCount += 1;
            }
        }
    }
}
