package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7569 {
    static int row, col, height;
    static int[][][] map;

    static int[] dheight = {1, -1, 0, 0, 0, 0};
    static int[] drow = {0, 0, 1, -1, 0, 0};
    static int[] dcol = {0, 0, 0, 0, 1, -1};
    static ArrayList<int[]> goodTomato = new ArrayList<>();
    static int tomatoCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        map = new int[height][row][col];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < col; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j][k] = value;
                    if (value == 1) {
                        goodTomato.add(new int[]{i, j, k});
                        tomatoCount += 1;
                    } else if (value == 0) {
                        tomatoCount += 1;
                    }
                }
            }
        }

        if (tomatoCount == goodTomato.size()) {
            System.out.println(0);
            return;
        }

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for (int[] tomato : goodTomato) {
            q1.offer(tomato);
        }
        int turn = 1;
        int day = 0;
        while ((!q1.isEmpty() || !q2.isEmpty())) {
            if (turn == 1) {
                int[] tomato = q1.poll();
                for (int i = 0; i < 6; i++) {
                    int nextHeight = tomato[0] + dheight[i];
                    int nextRow = tomato[1] + drow[i];
                    int nextCol = tomato[2] + dcol[i];

                    if (0 <= nextHeight && nextHeight < height && 0 <= nextRow && nextRow < row && 0 <= nextCol && nextCol < col) {
                        if (map[nextHeight][nextRow][nextCol] == 0) {
                            map[nextHeight][nextRow][nextCol] = 1;
                            int[] nextTomato = new int[]{nextHeight, nextRow, nextCol};
                            goodTomato.add(nextTomato);
                            q2.offer(nextTomato);
                        }
                    }
                }

                if (q1.isEmpty()) {
                    turn = 2;
                    day += 1;
                    if (goodTomato.size() == tomatoCount) {
                        break;
                    }
                }
            } else {
                int[] tomato = q2.poll();
                for (int i = 0; i < 6; i++) {
                    int nextHeight = tomato[0] + dheight[i];
                    int nextRow = tomato[1] + drow[i];
                    int nextCol = tomato[2] + dcol[i];

                    if (0 <= nextHeight && nextHeight < height && 0 <= nextRow && nextRow < row && 0 <= nextCol && nextCol < col) {
                        if (map[nextHeight][nextRow][nextCol] == 0) {
                            map[nextHeight][nextRow][nextCol] = 1;
                            int[] nextTomato = new int[]{nextHeight, nextRow, nextCol};
                            goodTomato.add(nextTomato);
                            q1.offer(nextTomato);
                        }
                    }
                }

                if (q2.isEmpty()) {
                    turn = 1;
                    day += 1;
                    if (goodTomato.size() == tomatoCount) {
                        break;
                    }
                }
            }

        }


        if (goodTomato.size() == tomatoCount) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }

    }
}
