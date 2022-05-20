package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
input
3 3
3 1 2
4 1 4
2 2 2
output
2
---
input
2 4
7 3 1 8
3 3 3 4
output
3
 */
public class greedy2 {
    static int MAX_VALUE = 10001;
    static int MIN_VALUE = 0;

    static int rowNum;
    static int colNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        rowNum = Integer.parseInt(st.nextToken());
        colNum = Integer.parseInt(st.nextToken());

        int result = MIN_VALUE;
        for(int i = 0; i < rowNum; i++){
            int min = MAX_VALUE;
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < colNum; j++){

                int value = Integer.parseInt(st.nextToken());
                min = Math.min(value, min);

            }
            result = Math.max(min, result);
        }

        System.out.println(result);
    }
}
