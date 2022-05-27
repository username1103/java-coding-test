package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
input
15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
output
8
 */
public class dfs_bfs1 {
    public static int rowConut;
    public static int colConut;

    public static int[] drow = {-1, 1, 0, 0};
    public static int[] dcol = {0, 0, -1, 1};

    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        rowConut = Integer.parseInt(st.nextToken());
        colConut = Integer.parseInt(st.nextToken());

        graph = new int[rowConut][colConut];

        for (int i = 0; i < rowConut; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int result = 0;

        for (int i = 0; i < rowConut; i++) {
            for (int j = 0; j < colConut; j++) {
                if (graph[i][j] == 0) {
                    result += 1;
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] loc = q.poll();

            int curRow = loc[0];
            int curCol = loc[1];
            graph[curRow][curCol] = 1;

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + drow[i];
                int nextCol = curCol + dcol[i];

                if (nextRow < rowConut && nextRow >= 0 && nextCol < colConut && nextCol >= 0 && graph[nextRow][nextCol] == 0) {
                    graph[nextRow][nextCol] = 1;
                    q.offer(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}
