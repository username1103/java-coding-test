package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
input
5 Dongbin
Hanul Jonggu Dongbin Taeil Sangwook
output
3
 */
public class LinearSearch {


    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        count = Integer.parseInt(st.nextToken());

        String target = st.nextToken();

        String[] array = new String[count];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < count; i++) {
            array[i] = st.nextToken();
        }


        int result = sequential_search(target, array);

        System.out.println(result);

    }

    static int sequential_search(String target, String[] array)  {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i + 1;
            }
        }
        return 0;
    }
}
