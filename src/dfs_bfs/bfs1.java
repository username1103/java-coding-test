package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class bfs1 {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int index = q.poll();
            System.out.print(index + " ");
            for (int i = 0; i < graph.get(index).size(); i++) {
                int adjacency_index = graph.get(index).get(i);
                if (!visited[adjacency_index]) {
                    q.offer(adjacency_index);
                    visited[adjacency_index] = true;
                }
            }


        }
    }
}
