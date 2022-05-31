package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
input
4 6
19 15 10 17
output
15
 */
public class BinarySearch2 {

    static int count;

    static int wantedLength;

    static int[] dduks;


    static int result = Integer.MAX_VALUE;
    static int maxLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        count = Integer.parseInt(st.nextToken());
        wantedLength = Integer.parseInt(st.nextToken());

        dduks = new int[count];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            int dduk = Integer.parseInt(st.nextToken());
            dduks[i] = dduk;
            maxLength = Math.max(dduk, maxLength);
        }

        binary_cut(0, maxLength);

        System.out.println(result);
    }
    static void binary_cut( int start, int end){
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;

        int dduksLength = getDduksLength(mid);
        if(dduksLength >= wantedLength){
            result = mid;
            binary_cut(mid + 1, end);
        } else {
            binary_cut(start, mid - 1);
        }
    }

    static int getDduksLength(int length){
        int result = 0;
        for (int dduk : dduks) {
            int diff =  dduk - length;
            if (diff > 0) {
                result += diff;
            }
        }
        return result;
    }
}
