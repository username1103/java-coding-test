package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ14003 가장 긴 증가하는 부분 수열 5
 */
public class BOJ14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] values = new int[n];
        int[] lis = new int[n];
        int[] d = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = values[0];
        int maxLength = 1;
        d[0] = maxLength; // 1, 2, 3, 4 순서로 저장(시작이 1)

        for (int i = 1; i < n; i++) {
            int value = values[i];

            // 앞에 값보다 크면 바로 저장
            if (value > lis[maxLength - 1]) {
                lis[maxLength] = value;
                maxLength += 1;
                d[i] = maxLength;
            } else {
                // value 보다 큰 값중 가장 작은 값을 lis 에서 찾음
                int start = 0;
                int end = maxLength;

                while(start < end){
                    int mid = (start + end) / 2;

                    if(lis[mid] < value){
                        start = mid + 1;
                    } else if(lis[mid] == value){
                        end = mid;
                    } else {
                        end = mid;
                    }
                }
                d[i] = end + 1; // 시작이 1이라 + 1 해줌
                lis[end] = value;
            }
        }
        int result = maxLength;

        // 뒤에서 부터 가장 긴 값부터 해당하는 값을 순서대로 찾아 스택에 저장
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(d[n - i - 1] == maxLength){
                s.push(values[n - i - 1]);
                maxLength -= 1;
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }

        System.out.println(result);
        System.out.println(sb);



    }
}
