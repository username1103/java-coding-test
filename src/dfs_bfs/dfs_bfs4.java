package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class dfs_bfs4 {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        int result = solution(board);
        System.out.println(result);
    }

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Robot {
        Point one, two;

        int moveCount = 0;

        public Robot(Point one, Point two, int moveCount) {
            this.one = one;
            this.two = two;
            this.moveCount = moveCount;
        }

        public boolean isArrived(int[][] board) {
            return (one.row == board.length - 1 && one.col == board.length - 1) || (two.row == board.length - 1 && two.col == board.length - 1);
        }

        public ArrayList<Point[]> getNextMoves(int[][] board) {
            ArrayList<Point[]> nextPos = new ArrayList<>();
            int[] drow = {-1, 1, 0, 0};
            int[] dcol = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nextOneRow = one.row + drow[i];
                int nextOneCol = one.col + dcol[i];
                int nextTwoRow = two.row + drow[i];
                int nextTwoCol = two.col + dcol[i];

                if (0 <= nextOneRow && nextOneRow <= board.length - 1 && 0 <= nextOneCol && nextOneCol <= board.length - 1 && 0 <= nextTwoRow && nextTwoRow <= board.length - 1 && 0 <= nextTwoCol && nextTwoCol <= board.length - 1) {
                    if (board[nextOneRow][nextOneCol] == 0 && board[nextTwoRow][nextTwoCol] == 0) {
                        nextPos.add(new Point[]{new Point(nextOneRow, nextOneCol), new Point(nextTwoRow, nextTwoCol)});
                    }
                }
            }

            // 가로
            if (one.row == two.row) {
                if (1 <= one.row) {
                    if (board[one.row - 1][one.col] == 0 && board[two.row - 1][two.col] == 0) {
                        nextPos.add(new Point[]{new Point(one.row, one.col), new Point(two.row - 1, one.col)});
                        nextPos.add(new Point[]{new Point(two.row, two.col), new Point(one.row - 1, two.col)});
                    }
                }
                if (one.row <= board.length - 2) {
                    if (board[one.row + 1][one.col] == 0 && board[two.row + 1][two.col] == 0) {
                        nextPos.add(new Point[]{new Point(one.row, one.col), new Point(two.row + 1, one.col)});
                        nextPos.add(new Point[]{new Point(two.row, two.col), new Point(one.row + 1, two.col)});
                    }
                }

            }

            // 세로
            if (one.col == two.col) {
                if (1 <= one.col) {
                    if (board[one.row][one.col - 1] == 0 && board[two.row][two.col - 1] == 0) {
                        nextPos.add(new Point[]{new Point(one.row, one.col), new Point(one.row, two.col - 1)});
                        nextPos.add(new Point[]{new Point(two.row, two.col), new Point(two.row, one.col - 1)});
                    }
                }

                if (one.col <= board.length - 2) {
                    if (board[one.row][one.col + 1] == 0 && board[two.row][two.col + 1] == 0) {
                        nextPos.add(new Point[]{new Point(one.row, one.col), new Point(one.row, two.col + 1)});
                        nextPos.add(new Point[]{new Point(two.row, two.col), new Point(two.row, one.col + 1)});
                    }
                }
            }

            return nextPos;
        }
    }


    public static int solution(int[][] board) {
        Robot robot = new Robot(new Point(0, 0), new Point(0, 1), 0);

        Queue<Robot> q = new LinkedList<>();
        ArrayList<Point[]> visited = new ArrayList<>();

        q.offer(robot);
        visited.add(new Point[]{robot.one, robot.two});

        while (!q.isEmpty()) {
            Robot cur = q.poll();
//            System.out.println("one: " + cur.one.row + ", " + cur.one.col + ", two: " + cur.two.row + ", " + cur.two.col);
            if (cur.isArrived(board)) {
                return cur.moveCount;
            }

            ArrayList<Point[]> nextPos = cur.getNextMoves(board);
            for (Point[] pos : nextPos) {
                boolean isVisited = false;
                for (Point[] p : visited) {
                    if (p[0].row == pos[0].row && p[0].col == pos[0].col && p[1].row == pos[1].row && p[1].col == pos[1].col) {
                        isVisited = true;
                        break;
                    }
                }
                if (!isVisited) {
                    visited.add(pos);
                    q.offer(new Robot(pos[0], pos[1], cur.moveCount + 1));
                }
            }
        }

        return 0;
    }

//    처음에 dfs로 시도해보았으나 시간초과가 발생함. 아마도 하나하나의 경우가 너무 깊어서 그런게 아닐까?
//    public static void dfs(Robot robot, int[][] board) {
//        System.out.println("one: " + robot.one.row + ", " + robot.one.col + ", two: " + robot.two.row + ", " + robot.two.col);
//        if (robot.isArrived(board)) {
//            result = Math.min(robot.moveCount, result);
//            return;
//        }
//
//        Point one = robot.one;
//        Point two = robot.two;
//        ArrayList<Point[]> nextRobots = robot.getNextMoves(board);
//        for (Point[] nextRobot : nextRobots) {
//            boolean isVisited = false;
//            for (Point[] p : robot.visited) {
//                if (p[0].row == nextRobot[0].row && p[0].col == nextRobot[0].col && p[1].row == nextRobot[1].row && p[1].col == nextRobot[1].col) {
//                    isVisited = true;
//                    break;
//                }
//            }
//            if (!isVisited) {
//                robot.visited.add(nextRobot);
//                robot.moveCount += 1;
//                robot.one = nextRobot[0];
//                robot.two = nextRobot[1];
//                dfs(robot, board);
//                robot.one = one;
//                robot.two = two;
//                robot.moveCount -= 1;
//
//                for (int i = 0; i < robot.visited.size(); i++) {
//                    Point[] p = robot.visited.get(i);
//                    if (p[0].row == nextRobot[0].row && p[0].col == nextRobot[0].col && p[1].row == nextRobot[1].row && p[1].col == nextRobot[1].col) {
//                        robot.visited.remove(i);
//                    }
//                }
//            }
//        }
//
//    }

}
