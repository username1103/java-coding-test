package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
input
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
output
10
20
14
18
17
 */
public class graph3 {
    static int lectureCount;
    static int[] inDegree;
    static int[] time;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        lectureCount = Integer.parseInt(st.nextToken());
        inDegree = new int[lectureCount + 1];
        time = new int[lectureCount + 1];

        for (int i = 0; i <= lectureCount; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= lectureCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");


            time[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                if (value == -1) break;
                adjList.get(value).add(i);
                inDegree[i] += 1;
            }
        }

        process();
    }


    static void process() {
        int[] result = time.clone();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= lectureCount; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curV = q.poll();

            for (int nextV : adjList.get(curV)) {
                inDegree[nextV] -= 1;
                result[nextV] = Math.max(result[nextV], time[nextV] + result[curV]);
                if (inDegree[nextV] == 0) {
                    q.offer(nextV);
                }
            }
        }

        for (int i = 1; i <= lectureCount; i++) {
            System.out.println(result[i]);
        }


    }
}
