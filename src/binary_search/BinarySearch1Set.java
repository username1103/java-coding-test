package binary_search;

import java.util.HashMap;
import java.util.HashSet;
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
public class BinarySearch1Set {
    static int count;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();

        HashSet<Integer> h = new HashSet<>();

        for (int i = 0; i < count; i++) {
            h.add(sc.nextInt());
        }

        int targetCount = sc.nextInt();
        for (int i = 0; i < targetCount; i++) {
            int target = sc.nextInt();
            if (h.contains(target)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");

            }
        }


    }
}
