package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1167 {
    static class Node {
        int idx;
        int d;

        public Node(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }
    }

    static int v;
    static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
    static boolean[] visited;
    static long result = 0;

    static Node maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());

        visited = new boolean[v + 1];

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int idx = Integer.parseInt(st.nextToken());
                if (idx == -1) {
                    break;
                }
                int d = Integer.parseInt(st.nextToken());
                adjList.get(t).add(new Node(idx, d));
            }
        }
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[v + 1];
        visited[maxNode.idx] = true;
        dfs(maxNode.idx, 0);

        System.out.println(result);
    }

    static void dfs(int start, int distance) {
        for (Node node : adjList.get(start)) {
            if (!visited[node.idx]) {
                visited[node.idx] = true;
                distance += node.d;
                dfs(node.idx, distance);
                if (result < distance) {
                    maxNode = node;
                    result = Math.max(result, distance);
                }
                distance -= node.d;
                visited[node.idx] = false;
            }
        }
    }
}
