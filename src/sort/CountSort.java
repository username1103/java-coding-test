package sort;

import java.util.Arrays;

public class CountSort {

    static int MAX_VALUE = 9;

    public static void main(String[] args) {
        int[] a = {1, 9, 6, 3, 7, 2, 0};

        int[] result = new int[MAX_VALUE + 1];

        for (int k : a) {
            result[k] += 1;
        }

        for (int i = 0; i <= MAX_VALUE; i++) {
            for (int j = 0; j < result[i]; j++) {
                System.out.println(i);
            }
        }
    }

}
