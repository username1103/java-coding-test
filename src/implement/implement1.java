package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
input
5
R R R U D D
output
3 4
 */
public class implement1 {

    static int mapSize;
    static int row = 1;
    static int col = 1;

    static void moveTo(String direction) {
        switch (direction){
            case "L":
                if(row > 1) row -= 1;
                break;
            case "R":
                if(row < mapSize) row += 1;
                break;
            case "U":
                if(col > 1) col -= 1;
                break;
            case "D":
                if(col < mapSize) col += 1;
                break;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            String direction = st.nextToken();
            moveTo(direction);
        }

        String result = col + " " + row;

        System.out.println(result);

    }
}
