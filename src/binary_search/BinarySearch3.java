package binary_search;

import java.io.*;
import java.util.*;

/*
input
7 2
1 1 2 2 2 2 3
output
4
input
7 4
1 1 2 2 2 2 3
output
-1
 */
public class BinarySearch3 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int lowerBound = getLowerBound(values, target, 0, n);
        int upperBound = getUpperBound(values, target, 0, n);

        int result = upperBound - lowerBound;

        System.out.println(result == 0 ? -1 : result);
    }

    static int getLowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else if (arr[mid] == target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    static int getUpperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) start = mid + 1;
            else if (arr[mid] == target) start = mid + 1;
            else end = mid;
        }
        return end;
    }
}
