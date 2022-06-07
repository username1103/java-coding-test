package BOJ;

import java.util.Scanner;
/*
input
3
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
output
2
1
0
 */
public class BOJ1002 {
    static int t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int result = find(x1, y1, r1, x2, y2, r2);
            System.out.println(result);
        }
    }

    static int find(int x1,int y1,int r1,int x2,int y2,int r2){
        double pointLength = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double radiusSum = r1 + r2;
        double radiusSub = Math.abs(r1 - r2);

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        if (radiusSub < pointLength && radiusSum > pointLength) {
            return 2;
        } else if(radiusSum == pointLength || radiusSub ==pointLength){
            return 1;
        } else if(radiusSub > pointLength || radiusSum < pointLength){
            return 0;
        } else {
            return -1;
        }
    }
}
