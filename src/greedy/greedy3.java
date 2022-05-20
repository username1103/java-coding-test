package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
input
25 5
output
2
---
input
17 4
output
3
 */
public class greedy3 {
    static int origin;
    static int divider;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        origin = Integer.parseInt(st.nextToken());
        divider = Integer.parseInt(st.nextToken());

        int target = origin;
        int count = 0;
        while(target != 1){
            int r = target % divider;

            if(r == 0){
                target /= divider;
                count += 1;
            } else {
                target -= r;
                count += r;
            }
        }

        System.out.println(count);
    }
}
