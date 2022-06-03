package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
input
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
output
0 4 8 6
3 0 7 9
5 9 0 4
7 11 2 0
 */
public class Floyd_Warshall {

    static final int INF = (int) 1e9;
    static int nodeCount;
    static int edgeCount;
    static int[][] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        edgeCount = Integer.parseInt(st.nextToken());

        graph = new int[nodeCount + 1][nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i < nodeCount + 1; i++) {
            graph[i][i] = 0;
        }


        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int index1 = Integer.parseInt(st.nextToken());
            int index2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph[index1][index2] = distance;
        }

        for (int i = 1; i < nodeCount + 1; i++) {
            for (int j = 1; j < nodeCount + 1; j++) {
                for (int k = 1; k < nodeCount + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i = 1; i < nodeCount + 1; i++) {
            for (int j = 1; j < nodeCount + 1; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
