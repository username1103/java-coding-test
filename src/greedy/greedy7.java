package greedy;

import java.util.Scanner;

/*
input
5 3
1 3 2 3 2
output
8
input
8 5
1 5 4 3 2 4 5 2
output
25
 */
public class greedy7 {
    static int ballCount;
    static int maxWeight;

    static int[] balls;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ballCount = sc.nextInt();
        maxWeight = sc.nextInt();


        balls = new int[maxWeight + 1];
        for (int i = 0; i < ballCount; i++) {
            int ball = sc.nextInt();
            balls[ball] += 1;
        }

        int result = 0;

        int biggerBallCount = ballCount;
        for (int i = 1; i <= maxWeight; i++) {
            biggerBallCount -= balls[i];
            result += balls[i] * biggerBallCount;
        }

        System.out.println(result);

    }
}
