package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502 {
    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Combination {
        private final int n;
        private final int r;
        private final int[] now;
        private final ArrayList<ArrayList<Point>> result;

        public Combination(int n, int r) {
            this.n = n;
            this.r = r;
            this.now = new int[r];
            this.result = new ArrayList<>();
        }

        public void combination(ArrayList<Point> arr, int depth, int index, int target) {
            if (depth == r) {
                ArrayList<Point> temp = new ArrayList<>();
                for (int i = 0; i < now.length; i++) {
                    temp.add(arr.get(now[i]));
                }

                result.add(temp);
                return;
            }

            if (target == n) {
                return;
            }

            now[index] = target;
            combination(arr, depth + 1, index + 1, target + 1);
            combination(arr, depth, index, target + 1);
        }

        public ArrayList<ArrayList<Point>> getResult() {
            return result;
        }
    }

    static int row, col;
    static int[][] map;
    static ArrayList<Point> viruses = new ArrayList<>();
    static ArrayList<Point> empties = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    viruses.add(new Point(i, j));
                } else if (map[i][j] == 0) {
                    empties.add(new Point(i, j));
                }
            }
        }

        Combination comb = new Combination(empties.size(), 3);
        comb.combination(empties, 0, 0, 0);
        ArrayList<ArrayList<Point>> results = comb.getResult();


        int safeAreaCount = 0;
        for (ArrayList<Point> result : results) {
            int[][] copiedMap = deepCopyMap();

            // 벽 세우기
            for (Point wall : result) {
                copiedMap[wall.row][wall.col] = 1;
            }

            // 확산
            bfs(copiedMap);

            // 안전범위 확인
            safeAreaCount = Math.max(getSafeAreaCount(copiedMap), safeAreaCount);
        }

        System.out.println(safeAreaCount);

    }

    static void bfs(int[][] copiedMap) {
        int[] drow = new int[]{-1, 1, 0, 0};
        int[] dcol = new int[]{0, 0, 1, -1};

        Queue<Point> q = new LinkedList<>();

        for (Point virus : viruses) {
            q.offer(virus);
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + drow[i];
                int nextCol = cur.col + dcol[i];
                if (0 <= nextRow && nextRow < row && 0 <= nextCol && nextCol < col && copiedMap[nextRow][nextCol] == 0) {
                    copiedMap[nextRow][nextCol] = 2;
                    q.offer(new Point(nextRow, nextCol));
                }
            }
        }
    }

    static int getSafeAreaCount(int[][] map) {
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    result += 1;
                }
            }
        }
        return result;
    }

    static int[][] deepCopyMap() {
        int[][] copiedMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
        return copiedMap;
    }
}
