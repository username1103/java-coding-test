package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
input
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
output
3
 */

public class implement4 {
    static int maxRow;
    static int maxCol;

    static int MAX_ROTATE_COUNT = 4;
    static int currentRow;
    static int currentCol;
    static int currentDirection;

    static int result = 0;

    static int rotateCount = 0;

    static int[][] map;

    static void rotate() {
        if (currentDirection == 0) currentDirection = 3;
        else currentDirection -= 1;
        rotateCount += 1;
    }

    static int[][] moveTypes = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static boolean canGo() {
        int[] moveType = moveTypes[currentDirection];
        int expectedRow = currentRow + moveType[0];
        int expectedCol = currentCol + moveType[1];

        return map[expectedRow][expectedCol] == 0;
    }

    static void go() {
        int[] moveType = moveTypes[currentDirection];
        currentRow += moveType[0];
        currentCol += moveType[1];
        map[currentRow][currentCol] = 2;
        rotateCount = 0;
        result += 1;
    }

    static boolean canBack() {
        int[] moveType = moveTypes[currentDirection];
        int expectedRow = currentRow - moveType[0];
        int expectedCol = currentCol - moveType[1];

        return map[expectedRow][expectedCol] != 1;
    }

    static void back() {
        int[] moveType = moveTypes[currentDirection];
        currentRow -= moveType[0];
        currentCol -= moveType[1];
        rotateCount = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        currentRow = Integer.parseInt(st.nextToken());
        currentCol = Integer.parseInt(st.nextToken());
        currentDirection = Integer.parseInt(st.nextToken());

        map = new int[maxRow][maxCol];

        map[currentRow][currentCol] = 2;

        for (int i = 0; i < maxRow; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < maxCol; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            rotate();
            if (canGo()) {
                go();
                continue;
            }
            if (rotateCount == MAX_ROTATE_COUNT) {
                if (canBack()) back();
                else break;
            }
        }

        System.out.println(result);
    }
}
