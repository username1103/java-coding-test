package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        int[] scores = new int[count];
        st = new StringTokenizer(br.readLine(), " ");

        int maxValue = 0;
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(st.nextToken());
            scores[i] = input;
            maxValue = Math.max(maxValue, input);
        }

        int finalMaxValue = maxValue;
        double[] changeScores = Arrays.stream(scores).mapToDouble((int val) -> (((double) val) / finalMaxValue) * 100).toArray();

        System.out.println(Arrays.stream(changeScores).average().getAsDouble());


    }
}
