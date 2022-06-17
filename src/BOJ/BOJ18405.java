package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18405 {
    static class Virus implements  Comparable<Virus>{
        int row, col, power;

        public Virus(int row, int col, int power) {
            this.row = row;
            this.col = col;
            this.power = power;
        }

        @Override
        public int compareTo(Virus o) {
            return power - o.power;
        }
    }
    static int size, virusCount;

    static int targetTime, targetRow, targetCol;
    static int[][] map;

    static int[] drow = new int[]{-1, 1, 0, 0};
    static int[] dcol = new int[]{0, 0, -1, 1};


    static PriorityQueue<Virus> pq1 = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        size = Integer.parseInt(st.nextToken());
        virusCount = Integer.parseInt(st.nextToken());

        map = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= size; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value != 0) {
                    pq1.offer(new Virus(i, j, value));
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        targetTime = Integer.parseInt(st.nextToken());
        targetRow = Integer.parseInt(st.nextToken());
        targetCol = Integer.parseInt(st.nextToken());

        PriorityQueue<Virus> pq2 = new PriorityQueue<>();


        int turn = 1;
        int time = 0;
        while (!pq1.isEmpty() || !pq2.isEmpty()) {
            if(time == targetTime) break;

            if (turn == 1) {
                Virus v = pq1.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = v.row + drow[i];
                    int nextCol = v.col + dcol[i];

                    if (1 <= nextRow && nextRow <= size && 1 <= nextCol && nextCol <= size && map[nextRow][nextCol] == 0) {
                        map[nextRow][nextCol] = v.power;
                        pq2.offer(new Virus(nextRow, nextCol, v.power));
                    }
                }

                if (pq1.isEmpty()) {
                    turn = 2;
                    time += 1;
                }
            } else {
                Virus v = pq2.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = v.row + drow[i];
                    int nextCol = v.col + dcol[i];

                    if (1 <= nextRow && nextRow <= size && 1 <= nextCol && nextCol <= size && map[nextRow][nextCol] == 0) {
                        map[nextRow][nextCol] = v.power;
                        pq1.offer(new Virus(nextRow, nextCol, v.power));
                    }
                }
                if (pq2.isEmpty()) {
                    turn = 1;
                    time += 1;
                }
            }

        }


        System.out.println(map[targetRow][targetCol]);
    }
}
