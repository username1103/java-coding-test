package implement;

public class implement6 {
    public static void main(String[] args) {
//        String s = "aabbaccc";
//        String s = "ababcdcdababcdcd";
//        String s = "abcabcdede";
//        String s = "abcabcabcabcdededededede";
        String s = "xababcdcdababcdcd";
        System.out.println(solution(s));

    }

    public static int solution(String s) {
        int result = s.length();

        for (int target = 1; target < s.length() / 2 + 1; target++) {
            StringBuilder sb = new StringBuilder();
            int num = 1;
            int cur;
//            System.out.println(target);
            for (cur = target; cur < s.length(); cur += target) {
                String sub1 = s.substring(cur - target, cur);
                String sub2 = s.substring(cur, Math.min(cur + target, s.length()));
                if (sub1.equals(sub2)) {
                    num += 1;
                } else {
                    if (num == 1) {
                        sb.append(sub1);
//                        System.out.println(sb);
                    } else {
                        sb.append(num).append(sub1);
//                        System.out.println(sb);
                        num = 1;
                    }
                }
            }
            if (num == 1) {
                sb.append(s.substring(cur - target));
//                System.out.println("잉여1");
//                System.out.println(sb);
            } else {
                sb.append(num).append(s, cur - target, cur);
//                System.out.println("잉여2");
//                System.out.println(sb);
            }
            result = Math.min(result, sb.length());
        }

        return result;
    }
}
