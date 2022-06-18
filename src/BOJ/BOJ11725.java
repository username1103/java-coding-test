package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11725 {
    static int n;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        parent = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        parent[1] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int node : adjList.get(cur)) {
                if (parent[node] == 0) {
                    parent[node] = cur;
                    q.offer(node);
                }
            }
        }

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }


    }

}
