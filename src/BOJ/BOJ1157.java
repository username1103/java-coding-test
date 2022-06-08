package BOJ;

import java.util.Scanner;

public class BOJ1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        char[] alphabets = new char['Z' - 'A' + 1];
        int maxCount = 0;
        char maxValue = 0;
        int duplicate = 0;

        for (char val : input.toCharArray()) {
            int cur = Character.toUpperCase(val) - 'A';
            alphabets[cur] += 1;
            if(alphabets[cur] > maxCount){
                maxCount = alphabets[cur];
                duplicate = 0;
                maxValue = Character.toUpperCase(val);
            } else if(alphabets[cur] == maxCount){
                duplicate += 1;
            }
        }

        System.out.println(duplicate > 0 ? '?' : maxValue);
    }
}
