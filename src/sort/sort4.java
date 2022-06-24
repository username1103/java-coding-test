package sort;

import java.util.*;

public class sort4 {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

//        int N = 4;
//        int[] stages = {4, 4, 4, 4, 4};
        int[] result = solution(N, stages);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static class Stage implements Comparable<Stage> {
        int self;
        int count;
        double fail;

        public Stage(int self,int count) {
            this.self = self;
            this.count = count;
        }

        @Override
        public int compareTo(Stage o) {
            if (fail == o.fail) {
                return Integer.compare(self, o.self);
            }

            return Double.compare(o.fail, fail);
        }
    }


    public static int[] solution(int N, int[] stages) {

        ArrayList<Stage> s = new ArrayList<>();

        int length = stages.length;

        for (int i = 1; i <= N + 1; i++) {
            s.add(new Stage(i, 0));
        }

        // 각 스테이지 초기화
        for (int cur : stages) {
            s.get(cur - 1).count += 1;
        }

        for (int i = 0; i < s.size(); i++) {
//            처음에는 아래와 같이 작성하여 length 대신 total 을 사용했지만 앞에서부터 차례대로 세어지기 때문에 전체를 두고 차감하여 계산하도록 하여 성능 향상
//            int total = 0;
//            for (int j = i; j < s.size() ; j++) {
//                total += s.get(j).count;
//            }

            // i 스테이지까지 도달한 사람이 아예 없는 경우, 0/0이 되어버림 예시 5, [3,3,3,3]
            s.get(i).fail = length == 0 ? (double) 0 : (double) s.get(i).count / length;

            // 앞에서부터 확인하면 되기 때문에 전체에서 사람수 제거
            length -= s.get(i).count;
        }

        // 마지막 스테이지 제거
        List<Stage> a = s.subList(0, s.size() - 1);

        Collections.sort(a);

        return a.stream().mapToInt(o -> o.self).toArray();
    }
}
