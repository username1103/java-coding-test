package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
    static int n, m;
    static int[][] map;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();

    static int result = Integer.MAX_VALUE;
    static int closePlan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if (val == 1) {
                    houses.add(new int[]{i, j});
                } else if (val == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        closePlan = chickens.size() - m;

        close(0, closePlan, chickens.size());

        System.out.println(result);
    }

    public static void close(int start, int end, int chickensLength) {
        if (end == 0) {
            // 거리 계산
            int length = 0;
            for (int[] house : houses) {
                int min = Integer.MAX_VALUE;
                for (int[] chicken : chickens) {
                    if (map[chicken[0]][chicken[1]] == 2) {
                        min = Math.min(min, getDistance(house, chicken));
                        if (min == 1) {
                            break;
                        }
                    }
                }
                length += min;
            }

            result = Math.min(length, result);
            return;
        }

        if (start == chickensLength) {
            return;
        }

        // 치킨 폐업

        int[] chicken = chickens.get(start);

        map[chicken[0]][chicken[1]] = 0;
        close(start + 1, end - 1, chickensLength);
        map[chicken[0]][chicken[1]] = 2;
        close(start + 1, end, chickensLength);
    }

    public static void deepCopy(ArrayList<int[]> chickens, ArrayList<int[]> nextChickens) {
        for (int[] chicken : chickens) {
            nextChickens.add(new int[]{chicken[0], chicken[1]});
        }
    }

    public static int getDistance(int[] house, int[] chicken) {
        return Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
    }


}
