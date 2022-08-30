package BOJ;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1759 {

    static PriorityQueue<String> pq = new PriorityQueue<>();
    static int L;
    static int C;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        L = sc.nextInt();
        C = sc.nextInt();

        sc.nextLine();

        char[] values = new char[C];
        for (int i = 0; i < C; i++) {
            values[i] = sc.next().charAt(0);
        }

        Arrays.sort(values);

        combination(values, 0, "");

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void combination(char[] values, int depth, String now) {
        if (now.length() == L) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < now.length(); i++) {
                char cur = now.charAt(i);
                if(cur =='a' || cur =='e' || cur=='i' || cur =='o' || cur =='u') a++;
                else b++;
            }

            if(a >= 1 && b >= 2) pq.add(now);
            return;
        }

        if(depth == C) return;

        combination(values, depth + 1, now);

        now += values[depth];
        combination(values, depth + 1, now);
    }
}
