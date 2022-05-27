package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
input
5 6
101010
111111
000001
111111
111111
output
10
 */
public class dfs_bfs2 {
    static int rowCount;
    static int colCount;

    static int[][] graph;

    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        rowCount = Integer.parseInt(st.nextToken());
        colCount = Integer.parseInt(st.nextToken());


        graph = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int initRow = 0;
        int initCol = 0;
        
        bfs(initRow, initCol);

        System.out.println(graph[rowCount - 1][colCount - 1]);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            int curRow = loc[0];
            int curCol = loc[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dRow[i];
                int nextCol = curCol + dCol[i];
                if (0 <= nextRow && nextRow < rowCount && 0 <= nextCol && nextCol < colCount && graph[nextRow][nextCol] == 1) {
                    graph[nextRow][nextCol] = graph[curRow][curCol] + 1;
                    q.offer(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}
