package BOJ;

import java.util.*;


public class BOJ1918 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();

        // 1. 문자는 그대로 출력한다.
        // 2. (는 스택에 추가한다.
        // 3. )가 나오면 스택에서 다음이 (나올 때 까지 또는 스택이 빌때까지 출력한다. (제거해준다.
        // 4. +, -가 나오면 스택에 다음이 (가 나오거나 빌 때까지 출력한다. 이후 자기자신을 스택에 추가한다.
        // 5. *, /가 나오면 스택에 비지 않고 * 또는 /가 다음이면 출력한다. 이후 자기자신을 스택에 추가한다.
        // 6. 스택에 남은 전부를 출력한다.

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
