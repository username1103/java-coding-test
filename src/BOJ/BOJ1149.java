package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int houseCount;
    // 0: RED, 1: GREEN, 2: BLUE
    static int[][] housesColor;
    static int[][] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        houseCount = Integer.parseInt(st.nextToken());

        housesColor = new int[houseCount + 1][3];
        houses = new int[houseCount + 1][3];

        for (int i = 1; i <= houseCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            houses[i][0] = red;
            houses[i][1] = green;
            houses[i][2] = blue;
            
        }

        for (int i = 1; i <= houseCount ; i++) {
            housesColor[i][0] = Math.min(housesColor[i - 1][1], housesColor[i - 1][2]) + houses[i][0];
            housesColor[i][1] = Math.min(housesColor[i - 1][0], housesColor[i - 1][2]) + houses[i][1];
            housesColor[i][2] = Math.min(housesColor[i - 1][0], housesColor[i - 1][1]) + houses[i][2];
        }

        System.out.println(Math.min(Math.min(housesColor[houseCount][0], housesColor[houseCount][1]), housesColor[houseCount][2]));

    }
}
