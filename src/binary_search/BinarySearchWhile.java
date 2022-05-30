package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
input
10 7
1 3 5 7 9 11 13 15 17 19
output
3

input
10 7
1 3 5 6 9 11 13 15 17 19
output
-1
 */
public class BinarySearchWhile {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        count = Integer.parseInt(st.nextToken());

        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] array = new int[count];

        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = count - 1;
        int result = binary_search_recursive(array, target, start, end);

        System.out.println(result);
    }

    static int binary_search_recursive(int[] array, int target, int start, int end) {
        while(start <= end){
            int mid = (start + end) / 2;

            if(array[mid] == target){
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }


        }
        return -1;
    }
}
