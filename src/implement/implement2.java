package implement;

import java.util.Scanner;


/*
input
5
output
11475
 */
public class implement2 {
    static int maxHour;

    static int maxMinute = 60;
    static int maxSecond = 60;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxHour = sc.nextInt();

        int result = 0;

        for (int i = 0; i < maxHour + 1; i++) {
            for (int j = 0; j < maxMinute; j++){
                for(int k = 0; k < maxSecond; k++){
                    String time = "" + i + j + k;
                    if(time.contains("3")){
                        result += 1;
                    }
                }
            }
        }

        System.out.println(result);

        sc.close();
    }
}
