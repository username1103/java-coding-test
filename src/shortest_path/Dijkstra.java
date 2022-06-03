package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
input
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
output
0
2
3
1
2
4
 */
public class Dijkstra {
    static class Node implements Comparable<Node> {
        private final int index;

        private final int distance;

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }


        @Override
        public int compareTo(Node o) {
            if(this.distance < o.distance){
                return -1;
            }
            return 1;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int nodeCount;

    static int edgeCount;

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static int[] d = new int[100001];

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int startIndex = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, distance));
        }

        Arrays.fill(d, INF);

        dijkstra(startIndex);

        for (int i = 1; i <= nodeCount; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }
    }

    static void dijkstra(int start){
        // 기본적으로 작은게 우선순위가 높음
        // 역순으로 가져오고 싶면 Collections.reversOrder() 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int index = node.getIndex();
            int distance = node.getDistance();

            if (d[index] < distance) {
                continue;
            }

            for (Node adjacencyNode : graph.get(index)) {
                int adjIndex = adjacencyNode.getIndex();
                int adjDistance = adjacencyNode.getDistance();
                int cost = d[index] + adjDistance;

                if (cost < d[adjIndex]) {
                    d[adjIndex] = cost;
                    pq.offer(new Node(adjIndex, cost));
                }

            }

        }


    }
}
