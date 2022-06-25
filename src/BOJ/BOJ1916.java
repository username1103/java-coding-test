package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ1916 {

    static class Node implements Comparable<Node> {
        int value;
        int cost;

        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static int n;
    static int m;

    static int[] d;

    static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            adjList.get(start).add(new Node(end, val));

        }

        st = new StringTokenizer(br.readLine(), " ");
        int src = Integer.parseInt(st.nextToken());
        int des = Integer.parseInt(st.nextToken());

        // 다익스트라
        // 1. 최단 거리 배열을 초기화한다.
        // 2. 시작하는 위치와 비용을 큐에 넣고, 해당 노드까지 거리를 초기화한다.
        // 3. 현재 큐에서 가장 가까운 인접노드 부터
        // 3-1. 현재위치를 거쳐 해당하는 인접위치까지 가능 비용을 구한다.
        // 3-2. 현재 저장되어 있는 인접위치까지 거리와 비교한다.
        // 3-3. 구한 비용이 더 작다면, 최단 거리 배열을 비용으로 변경하고 큐에 해당 위치까지 가는 비용을 포함한 노드를 추가한다.
        // 4. 큐가 빌 때까지 3번을 반복한다.

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));
        d[src] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (d[cur.value] < cur.cost) {
                continue;
            }

            for (Node adjNode : adjList.get(cur.value)) {
                int cost = d[cur.value] + adjNode.cost;
                if (cost < d[adjNode.value]) {
                    d[adjNode.value] = cost;
                    pq.offer(new Node(adjNode.value, cost));
                }
            }
        }

        System.out.println(d[des]);
    }
}
