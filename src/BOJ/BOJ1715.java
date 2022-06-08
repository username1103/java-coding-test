package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1715 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (!pq.isEmpty() && pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            result += a + b;
            pq.offer(a + b);
        }

        System.out.println(result);
    }
}
