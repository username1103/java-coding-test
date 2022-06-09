package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17143{

    static int row, col, sharkCount;
    static int result;
    static Shark[][] pool;
    static ArrayList<Shark> sharks = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void catchShark(int y) {
        for(int i = 0; i < row; i++) {

            if(pool[i][y] != null) {
                Shark now = pool[i][y];
                pool[i][y] = null;
                result += now.size;
                sharks.remove(now);
                break;
            }
        }
    }

    static void move() {
        for (Shark shark : sharks) {
            shark.updatePosition();
        }
    }


    static void survive() {
        pool = new Shark[row][col];
        int size = sharks.size();
        for(int i = size - 1; i >= 0; i--) {
            Shark shark = sharks.get(i);

            if(pool[shark.curCol][shark.curRow] == null) {
                pool[shark.curCol][shark.curRow] = shark;
            }

            else {
                if(pool[shark.curCol][shark.curRow].size > shark.size) {
                    sharks.remove(shark);
                }else {
                    sharks.remove(pool[shark.curCol][shark.curRow]);
                    pool[shark.curCol][shark.curRow] = shark;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        sharkCount = Integer.parseInt(st.nextToken());

        pool = new Shark[row][col];

        for(int i = 0; i < sharkCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken()) - 1;
            int size = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(row, col, speed, direction, size);
            pool[row][col] = shark;
            sharks.add(shark);
        }

        for(int i = 0; i < col; i++) {
            catchShark(i);
            move();
            survive();
        }

        System.out.println(result);
    }

    static class Shark {
        int curCol;
        int curRow;
        int speed;
        int direction;
        int size;

        public Shark(int x, int y, int speed, int dir, int size) {
            this.curCol = x;
            this.curRow = y;
            this.speed = speed;
            this.direction = dir;
            this.size = size;
        }

        void updatePosition() {
            int move = this.speed;
            // 위 아래
            if(direction < 2) {
                move %= ((row -1) * 2);
                while (move > 0) {
                    if(curCol == 0) {
                        direction = 1;
                    }
                    if(curCol == row -1) {
                        direction = 0;
                    }
                    curCol += dx[direction];
                    move--;
                }
            }
            // 좌우
            else {
                move %= ((col -1) * 2);
                while (move > 0) {
                    if(curRow == 0) {
                        direction = 2;
                    }
                    if(curRow == col -1) {
                        direction = 3;
                    }
                    curRow += dy[direction];
                    move--;
                }
            }
        }
    }
}