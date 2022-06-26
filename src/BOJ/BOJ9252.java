package BOJ;

import java.util.Scanner;

public class BOJ9252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String one = sc.nextLine();
        String two = sc.nextLine();

        int[][] t = new int[one.length() + 1][two.length() + 1];

        // 일반적인 LCS 수행
        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < two.length(); j++) {

                char a = one.charAt(i);
                char b = two.charAt(j);

                if (a == b) {
                    t[i + 1][j + 1] = t[i][j] + 1;
                } else {
                    t[i + 1][j + 1] = Math.max(t[i][j + 1], t[i + 1][j]);
                }
            }
        }

        int length = t[one.length()][two.length()];
        System.out.println(length);

        if (length != 0) {
            // LCS 결과가 0이 아니면 끝에서 부터 구해나감
            // stringBuilder 에 추가후 최종적으로 뒤집음
            StringBuilder sb = new StringBuilder();
            int oneCur = one.length();
            int twoCur = two.length();

            while (oneCur > 0 && twoCur > 0) {
                if (t[oneCur][twoCur] == t[oneCur - 1][twoCur]) {
                    oneCur -= 1;
                } else if (t[oneCur][twoCur] == t[oneCur][twoCur - 1]) {
                    twoCur -= 1;
                } else {
                    sb.append(one.charAt(oneCur - 1));
                    oneCur -= 1;
                    twoCur -= 1;
                }
            }
            System.out.println(sb.reverse());
        }
    }
}
