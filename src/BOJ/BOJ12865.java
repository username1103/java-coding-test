package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ12865 {
    static class Product {
        int weight, value;

        public Product(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int count, maxWeight;

    static ArrayList<Product> products = new ArrayList<>();

    // 해당 Product, 무게까지 최댓값 저장
    static int[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        maxWeight = sc.nextInt();
        d = new int[count][maxWeight + 1];

        for (int i = 0; i < count; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            products.add(new Product(weight, value));
        }

        for (int i = 0; i < count; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                Product p = products.get(i);

                // 프로덕트 무게가 타겟 무게보다 크면 담을 수 없음.
                if (p.weight > j) {
                    if (i == 0) {
                        d[i][j] = 0;
                        continue;
                    }
                    // 담을 수 없으므로 이전 아이템까지의 최대 가치를 저장
                    d[i][j] = d[i - 1][j];
                }
                // 프로덕트 무게가 타겟 무게보다 작은 경우
                else {
                    if (i == 0) {
                        d[i][j] = p.value;
                        continue;
                    }

                    // 이전 아이템까지 넣은 가치와 이전 아이템까지 중 현재 프로덕트를 포함할 수 있는 가치중 큰 값
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - p.weight] + p.value);
                }
            }
        }

        System.out.println(d[count - 1][maxWeight]);
    }
}
