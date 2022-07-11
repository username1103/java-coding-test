package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ1005 ACM Craft
 * Topology Sort
 */
public class BOJ1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] costs = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                costs[j] = Integer.parseInt(st.nextToken());
            }

            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                adjList.add(new ArrayList<>());
            }

            int[] adjCounts = new int[N + 1];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                adjList.get(start).add(end);
                adjCounts[end] += 1;
            }

            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());


            int[] d = new int[N + 1];
            Queue<Integer> q = new LinkedList<>();

            for (int j = 1; j <= N; j++) {
                if (adjCounts[j] == 0) {
                    d[j] = costs[j];
                    q.offer(j);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : adjList.get(cur)) {
                    d[next] = Math.max(d[next], d[cur] + costs[next]);
                    adjCounts[next] -= 1;

                    if (adjCounts[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            System.out.println(d[target]);

        }
    }

}
