package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
input
5 3
1 2 5 4 3
5 5 6 6 5
output
26
 */
public class sort3 {
    static int listLength;
    static int changeCount;

    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        listLength = Integer.parseInt(st.nextToken());
        changeCount = Integer.parseInt(st.nextToken());

        A = new int[listLength];
        B = new int[listLength];


        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < listLength; j++) {
            A[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < listLength; j++) {
            B[j] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < changeCount; i++) {
            A[i] = B[B.length - 1 - i];
        }

        System.out.println(Arrays.stream(A).sum());
    }
}
