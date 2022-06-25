package BOJ;

import java.util.Scanner;

public class BOJ12015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] lis = new int[n];
        int[] values = new int[n];


        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        lis[0] = values[0];
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            int value = values[i];
            // 그냥 크면 추가
            if (value > lis[maxLength - 1]) {
                lis[maxLength] = value;
                maxLength += 1;
            } else {
                // 이분 탐색을 통해 해당하는 값보다 큰 가장 작은 값(upper bound)을 찾음
                int start = 0;
                int end = maxLength;

                while (start < end) {
                    int mid = (start + end) / 2;

                    if (lis[mid] < value) {
                        start = mid + 1;
                    } else if (lis[mid] == value) {
                        end = mid;
                    } else {
                        end = mid;
                    }
                }

                // 값보다 크지만 가장 작은 값(upper bound)값의 자리를 현재 값으로 변경
                lis[end] = value;
            }
        }
        // 길이를 구하기는 것이기 때문에 대치가 가능

        System.out.println(maxLength);
    }
}
