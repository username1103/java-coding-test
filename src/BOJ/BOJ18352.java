package BOJ;

import java.io.*;
import java.util.*;


public class BOJ18352 {
    static int cityCount, pathCount, target, init;

    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    static int[] lens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        cityCount = Integer.parseInt(st.nextToken());
        pathCount = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        init = Integer.parseInt(st.nextToken());

        lens = new int[cityCount + 1];
        Arrays.fill(lens, -1);
        for (int i = 0; i <= cityCount; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < pathCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList.get(start).add(end);
        }


        bfs(init);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < lens.length; i++) {
            if (lens[i] == target) {
                pq.offer(i);
            }
        }

        if(pq.isEmpty()){
            System.out.println(-1);
        } else {
            while (!pq.isEmpty()) {
                System.out.println(pq.poll());
            }
        }


    }

    static void bfs(int init) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(init);
        lens[init] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adjList.get(cur)) {
                if (lens[next] == -1) {
                    lens[next] = lens[cur] + 1;
                    q.offer(next);
                }
            }

        }
    }
}



