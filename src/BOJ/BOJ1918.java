package BOJ;

import java.util.*;

public class BOJ1918 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char val = input.charAt(i);

            if ('A' <= val && val <= 'Z') {
                sb.append(val);
            } else {
                if (val == '(') {
                    s.push(val);
                } else if (val == '*' || val == '/') {
                    while (!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')) sb.append(s.pop());
                    s.push(val);
                } else if (val == '+' || val == '-') {
                    while (!s.isEmpty() && s.peek() != '(') sb.append(s.pop());
                    s.push(val);
                } else if (val == ')') {
                    while (!s.isEmpty() && s.peek() != '(') sb.append(s.pop());
                    if (!s.isEmpty()) s.pop();
                }
            }
        }

        while (!s.isEmpty()) sb.append(s.pop());

        System.out.println(sb);

    }

}
