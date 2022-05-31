package binary_search;

import java.util.Scanner;

/*
input
5
8 7 3 9 2
3
5 7 9
output
no yes yes
 */

public class BinarySearch1CountSort {
    static int count;

    static int[] candidates = new int[1000001];

    static int targetCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int val = sc.nextInt();
            candidates[val] += 1;
        }

        targetCount = sc.nextInt();

        for (int i = 0; i < targetCount; i++) {
            int target = sc.nextInt();
            if (candidates[target] == 1) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }


    }
}
