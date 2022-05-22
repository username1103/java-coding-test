package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
input
a1
output
2
 */

public class implement3 {

    static int MAP_SIZE = 8;
    static int locationRow;
    static int locationCol;

    static String locationStr;

    static int[][] moveTypes = {{-2,-1},{-2,1},{2,-1},{2,1},{1,-2},{-1,-2},{1,2},{-1,2}};

    static boolean canMove(int[] moveType){
        int expectedRow = locationRow + moveType[0];
        int expectedCol = locationCol + moveType[1];

       return expectedRow >= 0 && expectedRow < MAP_SIZE && expectedCol >= 0 && expectedCol < MAP_SIZE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        locationStr = st.nextToken();

        locationCol = locationStr.charAt(0) - 'a';
        locationRow = locationStr.charAt(1) - '1';

        int result = 0;
        for (int[] moveType: moveTypes){
            if(canMove(moveType)){
                result += 1;
            }
        }

        System.out.println(result);
    }
}
