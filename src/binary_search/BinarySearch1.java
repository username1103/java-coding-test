package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
input
5
8 7 3 9 2
3
5 7 9
output
no yes yes
 */
public class BinarySearch1 {
    static int count;

    static int[] values;

    static int targetCount;

    static int[] targets;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());

        values = new int[count];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        targetCount = Integer.parseInt(st.nextToken());

        targets = new int[targetCount];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < targetCount; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        for (int target : targets) {
            System.out.print(binary_search(target) + " ");
        }
    }

    static String binary_search(int target){
        int start = 0;
        int end = values.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (values[mid] == target) {
                return "yes";
            } else if (values[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return "no";
    }
}
