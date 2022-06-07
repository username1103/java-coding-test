package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
input
5
2 3 1 2 2
output
2

input
4
1 2 3 3
output
2
 */
public class greedy4 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        ArrayList<Integer> group = new ArrayList<>();

        int result = 0;
        while (!pq.isEmpty()) {
            int newMember = pq.poll();
            group.add(newMember);

            boolean isSatisfied = true;
            for (int member : group) {
                if (member <= group.size()) {
                    continue;
                }
                isSatisfied = false;
            }

            if (isSatisfied) {
                group.clear();
                result += 1;
            }
        }

        System.out.println(result);

    }
}
