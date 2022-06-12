package BOJ;

import java.util.Scanner;
/*
2*1*3
2*(1+1)*3
2*(1+1+1)*3
...
 */
public class BOJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();

        int curValue = 1;
        int result = 1;
        int interval = 2;

        while (curValue < target) {
            curValue += interval * result * 3;
            result += 1;

        }

        System.out.println(result);

    }
}
