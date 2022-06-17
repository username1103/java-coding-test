package dfs_bfs;

public class dfs_bfs3 {

    public static void main(String[] args) {
        String p = "(()())()";
        String p1 = ")(";
        String p2 = "()))((()";

        System.out.println(solution(p));
        System.out.println(solution(p1));
        System.out.println(solution(p2));
    }

    public static String solution(String p) {
        String answer = "";

        // 1.
        if (p.equals("")) return answer;

        // 2.
        int leftCount = 0;
        int rightCount = 0;
        int index = p.length() - 1;
        for (int i = 0; i < p.length(); i++) {
            char value = p.charAt(i);
            if (value == '(') {
                leftCount += 1;
            } else {
                rightCount += 1;
            }

            if (leftCount == rightCount) {
                index = i;
                break;
            }
        }

        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        // 3.
        if(isValidString(u)){
            answer = u + solution(v);

        // 4.
        } else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1);
            String convertedU = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    convertedU += ")";
                } else {
                    convertedU += "(";
                }
            }
            answer += convertedU;

        }

        return answer;
    }

    public static boolean isValidString(String u){
        int count = 0;
        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) =='(') count += 1;
            else {
                if (count == 0) {
                    return false;
                }
                count -= 1;
            }
        }

        return true;
    }
}
