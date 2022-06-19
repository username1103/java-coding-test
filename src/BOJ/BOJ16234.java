package BOJ;

import java.util.*;

public class BOJ16234 {
    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int n, min, max;
    static int[][] map;
    static int[][] visited;

    static int[] drow = new int[]{-1, 1, 0, 0};
    static int[] dcol = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        min = sc.nextInt();
        max = sc.nextInt();
        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = -1;
        boolean hasMove = true;
        while (hasMove) {
            result += 1;
            ArrayList<ArrayList<Point>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], 0);
            }
            hasMove = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        // 연합 생성 및 자기 자신 추가, 연합에 국가 추가
                        ArrayList<Point> group = new ArrayList<>();
                        Point cur = new Point(i, j);
                        visited[i][j] = 1;
                        group.add(cur);
                        bfs(cur, group);
                        list.add(group);
                    }
                }
            }

            for (ArrayList<Point> group : list) {
                // 연합에 국가가 2개 이상인 경우에만
                if (group.size() > 1) {
                    int totalGroup = 0;
                    for (Point p : group) {
                        totalGroup += map[p.row][p.col];
                    }

                    for (Point p : group) {
                        // 이동이 한번이라도 되어야한다면
                        if (map[p.row][p.col] != totalGroup / group.size()) hasMove = true;
                        map[p.row][p.col] = totalGroup / group.size();
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(Point p, ArrayList<Point> group) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                Point next = new Point(cur.row + drow[i], cur.col + dcol[i]);
                if (0 <= next.row && next.row < n && 0 <= next.col && next.col < n) {
                    // 연합에 포함되었는가
                    if (visited[next.row][next.col] == 0) {
                        int diff = Math.abs(map[next.row][next.col] - map[cur.row][cur.col]);
                        if (min <= diff && diff <= max) {
                            visited[next.row][next.col] = 1;
                            group.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
        }
    }
}
