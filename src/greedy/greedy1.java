package greedy;

import java.io.*;
import java.util.*;

/*
input
5 8 3
2 4 5 4 6
output
46
 */
public class greedy1 {
    static int valueCount;

    static int sumCount;

    static int sameMaxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        valueCount = Integer.parseInt(st.nextToken());

        sumCount = Integer.parseInt(st.nextToken());

        sameMaxCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] values = new int[valueCount];

        for (int i = 0; i < valueCount; i++) {
            int value = Integer.parseInt(st.nextToken());
            values[i] = value;
        }

        Arrays.sort(values);

        int firstValue = values[valueCount - 1];
        int secondValue = values[valueCount - 2];

        int firstValueSumCount = (sumCount / (sameMaxCount + 1)) * sameMaxCount + sumCount % (sameMaxCount + 1);

        int result = firstValue * firstValueSumCount + secondValue * (sumCount - firstValueSumCount);

        System.out.println(result);
    }
}
