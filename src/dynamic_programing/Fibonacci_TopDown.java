package dynamic_programing;

public class Fibonacci_TopDown {
    static long[] d = new long[100];

    public static void main(String[] args) {

        System.out.println(fibo(50));

    }

    static long fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        if (d[x] != 0) {
            return d[x];
        }

        d[x] = fibo(x - 1) + fibo(x - 2);
        return d[x];
    }
}
