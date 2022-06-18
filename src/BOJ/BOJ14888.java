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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        values = new int[n];
        operations = new int[n - 1];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }


        int plusCount = sc.nextInt();
        for (int i = 0; i < plusCount; i++) {
            operations[i] = '+';
        }

        int minusCount = sc.nextInt();
        for (int i = plusCount; i <plusCount + minusCount ; i++) {
            operations[i] = '-';
        }

        int mulCount = sc.nextInt();
        for (int i = plusCount + minusCount; i < plusCount + minusCount + mulCount; i++) {
            operations[i] = '*';
        }

        int divCount = sc.nextInt();
        for (int i = plusCount+minusCount+mulCount; i <plusCount+minusCount+mulCount+divCount ; i++) {
            operations[i] = '/';
        }

        Permutation perm = new Permutation(operations.length, operations.length);
        perm.permutation(operations, 0);


        int max = -1000000001;
        int min = 1000000001;
        for (int i = 0; i < perm.results.size(); i++) {
            int[] result = perm.results.get(i);
            int temp = values[0];
            for (int j = 0; j < result.length; j++) {
                int operation = result[j];
                switch(operation){
                    case '+':
                        temp += values[j + 1];
                        break;
                    case '-':
                        temp -= values[j + 1];
                        break;
                    case '*':
                        temp *= values[j + 1];
                        break;
                    case '/':
                        temp /= values[j + 1];
                        break;
                }
            }
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }

        System.out.println(max);
        System.out.println(min);

    }
}
