package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
input
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
output
8
 */
public class graph2 {
    static int houseCount, pathCount;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        houseCount = Integer.parseInt(st.nextToken());
        pathCount = Integer.parseInt(st.nextToken());
        parent = new int[houseCount + 1];
        for (int i = 1; i <= houseCount ; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < pathCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(start, end, cost));
        }

        int maxCost = 0;
        int totalCost = 0;
        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();

            if (findParent(curEdge.start) != findParent(curEdge.end)) {
                union(curEdge.start, curEdge.end);
                totalCost += curEdge.cost;
                maxCost = Math.max(maxCost, curEdge.cost);
            }
        }

        System.out.println(totalCost - maxCost);


    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x < y) {
            parent[y] = x;
        }else {
            parent[x] = y;
        }
    }

    static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }
    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

}
