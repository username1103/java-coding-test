package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    static int n, m, v;

    static ArrayList<PriorityQueue<Integer>> adjList_dfs = new ArrayList<>();
    static ArrayList<PriorityQueue<Integer>> adjList_bfs = new ArrayList<>();
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            adjList_dfs.add(new PriorityQueue<>());
            adjList_bfs.add(new PriorityQueue<>());
        }
        visited_dfs = new boolean[n + 1];
        visited_bfs = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList_dfs.get(start).offer(end);
            adjList_bfs.get(start).offer(end);
            adjList_dfs.get(end).offer(start);
            adjList_bfs.get(end).offer(start);
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    public static void dfs(int v){
        visited_dfs[v] = true;
        System.out.print(v + " ");
        PriorityQueue<Integer> q = adjList_dfs.get(v);

        while (!q.isEmpty()) {
            int value = q.poll();
            if (!visited_dfs[value]) {
                dfs(value);
            }
        }

    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited_bfs[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            PriorityQueue<Integer> q2 = adjList_bfs.get(cur);
            while (!q2.isEmpty()) {
                int value = q2.poll();
                if (!visited_bfs[value]) {
                    q.offer(value);
                    visited_bfs[value] = true;
                }
            }
        }
    }
}
