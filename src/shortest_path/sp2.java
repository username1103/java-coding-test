package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
input
3 2 1
1 2 4
1 3 2
output
2 4
 */
public class sp2 {
    static class City implements Comparable<City> {
        private final int index;
        private final int time;

        public City(int index, int distance) {
            this.index = index;
            this.time = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(City o) {
            if(this.time < o.time){
                return -1;
            }
            return 1;
        }
    }
    static final int INF = (int) 1e9;
    static int cityCount;
    static int pathCount;
    static int start;
    static ArrayList<ArrayList<City>> edges = new ArrayList<>();

    static int[] d = new int[30001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        cityCount = Integer.parseInt(st.nextToken());
        pathCount = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= cityCount; i++) {
            edges.add(new ArrayList<>());
            d[i] = INF;
        }

        for (int i = 0; i < pathCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges.get(start).add(new City(end, time));
        }

        dijkstra(start);

        int maxTime = 0;
        int count = 0;
        for (int i = 1; i <= cityCount; i++) {
            if (d[i] != INF) {
                count += 1;
                maxTime = Math.max(maxTime, d[i]);
            }
        }
        System.out.println(count - 1 + " " + maxTime);
    }

    static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City((start), 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            City city = pq.poll();
            int curIdx = city.getIndex();
            int curTime = city.getTime();

            if (d[curIdx] < curTime) continue;

            for (City adjCity : edges.get(curIdx)) {
                int adjIdx = adjCity.getIndex();
                int adjTime = adjCity.getTime();

                int cost = d[curIdx] + adjTime;
                if (cost < d[adjIdx]) {
                    d[adjIdx] = cost;
                    pq.offer(new City(adjIdx, cost));
                }
            }

        }


    }
}
