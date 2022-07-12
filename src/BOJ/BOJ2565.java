package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] wires = new int[n + 1][2]; // [[A, B]]
        int[] d = new int[n + 1]; // i 번째 전깃줄까지 최대 설치 개수

        for (int i = 1; i <= n; i++) {
            wires[i][0] = sc.nextInt();
            wires[i][1] = sc.nextInt();
        }

        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int result = 1;
        for (int i = 1; i <= n; i++) { // 현재 A 전봇대에 있는 전깃줄보다 작은 전깃줄들 중, 해당 전깃줄과 연결된 B 전봇대 위치 보다 작은 위치로 연결된 줄까지 연결한 줄 + 1 중 가장 큰 것
            d[i] = 1;
            for (int j = 1; j < i; j++) { // 현재 전깃줄에 A 전봇대보다 작은 위치에 있는 전깃들 중
                if(wires[j][1] < wires[i][1]){ // B 전봇대에 연결된 위치가 현재 전깃줄의 B 전봇대 위치보다 작은 전깃줄
                    d[i] = Math.max(d[i], d[j] + 1); // 까지 최대 전깃줄 개수 + 1 과 현재 전깃줄까지 최대 개수 중 큰 값
                }
            }
            result = Math.max(result, d[i]);
        }

        System.out.println(n - result);
    }
}
