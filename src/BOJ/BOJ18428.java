package BOJ;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class BOJ18428 {

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Combination {
        int n, r;
        int[] now;
        ArrayList<ArrayList<Point>> results;

        public Combination(int n, int r) {
            this.n = n;
            this.r = r;
            this.now = new int[r];
            this.results = new ArrayList<>();
        }

        public void combination(ArrayList<Point> empty, int depth, int index, int target) {
            if (depth == r) {
                ArrayList<Point> temp = new ArrayList<>();
                for (int i = 0; i < now.length; i++) {
                    temp.add(empty.get(now[i]));
                }
                results.add(temp);
                return;
            }

            if (target == n) {
                return;
            }

            now[index] = target;
            combination(empty, depth + 1, index + 1, target + 1);
            combination(empty, depth, index, target + 1);
        }
    }

    static int size;

    static int[][] map;

    static ArrayList<Point> t = new ArrayList<>();
    static ArrayList<Point> empty = new ArrayList<>();
    static ArrayList<Point> s = new ArrayList<>();

    static int[] drow = new int[]{-1, 1, 0, 0};
    static int[] dcol = new int[]{0, 0, 1, -1};

    static boolean isSuccess;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        sc.nextLine();

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("X")) {
                    map[i][j] = 0;
                    empty.add(new Point(i, j));
                } else if (line[j].equals("T")) {
                    map[i][j] = 2;
                    t.add(new Point(i, j));
                } else {
                    map[i][j] = 1;
                    s.add(new Point(i, j));
                }
            }
        }

        Combination comb = new Combination(empty.size(), 3);
        comb.combination(empty, 0, 0, 0);


        String out = "NO";
        for (int i = 0; i < comb.results.size(); i++) {
            ArrayList<Point> result = comb.results.get(i);
            int[][] copiedMap = deepCopy(map);
            isSuccess = true;
            for (int j = 0; j < result.size(); j++) {
                Point p = result.get(j);
                copiedMap[p.row][p.col] = 3;
            }

            for (Point teacher : t) {
                if (!isSuccess) {
                    break;
                }
                dfs(teacher, 0, copiedMap);
                dfs(teacher, 1, copiedMap);
                dfs(teacher, 2, copiedMap);
                dfs(teacher, 3, copiedMap);
            }

            if (isSuccess) {
                out = "YES";
                break;
            }
        }

        System.out.println(out);
    }

    static void dfs(Point teacher, int direction, int[][] map) {
        int nextRow = teacher.row + drow[direction];
        int nextCol = teacher.col + dcol[direction];
        if (0 <= nextRow && nextRow < size && 0 <= nextCol && nextCol < size) {
            // 학생
            if (map[nextRow][nextCol] == 1) {
                isSuccess = false;
                // 땅
            } else if (map[nextRow][nextCol] == 0) {
                dfs(new Point(nextRow, nextCol), direction, map);
            }
        }
    }

    static int[][] deepCopy(int[][] map) {
        int[][] copied = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(map[i], 0, copied[i], 0, map[i].length);
        }
        return copied;
    }
}
