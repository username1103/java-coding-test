package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11660 {
    static int size, count;
    static int[][] map;

    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        size = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());

        // 해당좌표값(결과적으로 map 필요 없음)
        map = new int[size + 1][size + 1];

        // (0,0)에서 해당좌표까지의 합
        d = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // (3,4)의 좌표를 구한다고 하면, (2,4)까지 합과 (3,3)까지 합을 더한 후, 중복해서 더해진 (2,3)까지의 합을 빼고, (3,4)의 좌표값을 더한다.
                d[i][j] = d[i][j - 1] + d[i-1][j] - d[i-1][j-1] + map[i][j];
            }
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // (x2,y2)까지 합에서 (x1-1,y2)까지 합과 (x2,y1-1)까지 합을 빼고, 두 번 빼진 (x1-1,y1-1)까지 합을 다시 더하여줌
            int result = d[x2][y2] - d[x1 - 1][y2] - d[x2][y1 - 1] + d[x1 - 1][y1 - 1];


            System.out.println(result);
        }
    }
}
