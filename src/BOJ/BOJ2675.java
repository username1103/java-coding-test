package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            char[] sChars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : sChars) {
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }
}
