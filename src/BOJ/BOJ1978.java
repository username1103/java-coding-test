package BOJ;

import java.util.Scanner;

public class BOJ1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int result = 0;
        for (int i = 0; i < count; i++) {
            int target = sc.nextInt();
            if (isPrime(target)) {
                result += 1;
            }
        }
        System.out.println(result);
    }


    static boolean isPrime(int x){
        if (x == 1) {
            return false;
        }

        for (int i = 2; i < (int) Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
