package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
input
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
output
1 2 5 3 6 4 7
 */
public class TopologySort {
    static int v, e;
    static int[] inDegree;

    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        inDegree = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList.get(start).add(end);

            inDegree[end] += 1;
        }

        sort();
    }

    static void sort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curV = q.poll();
            result.add(curV);

            for (int nextV : adjList.get(curV)) {
                inDegree[nextV] -= 1;
                if (inDegree[nextV] == 0) {
                    q.offer(nextV);
                }
            }
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
