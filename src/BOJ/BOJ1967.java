package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1967 {
    static class Node {
        int self;
        int cost;

        public Node(int self, int cost) {
            this.self = self;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

    static int result = 0;
    static Node maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println(result);
            return;
        }


        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(start).add(new Node(end, cost));
            adjList.get(end).add(new Node(start, cost));
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0, visited);

        Arrays.fill(visited, false);
        visited[maxNode.self] = true;
        dfs(maxNode.self, 0, visited);

        System.out.println(result);
    }


    static void dfs(int start, int distance, boolean[] visited) {
        for (Node node : adjList.get(start)) {
            if (!visited[node.self]) {
                visited[node.self] = true;
                distance += node.cost;
                dfs(node.self, distance, visited);
                if (result < distance) {
                    maxNode = node;
                    result = distance;
                }
                distance -= node.cost;
                visited[node.self] = false;
            }
        }
    }
}
