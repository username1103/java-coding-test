package implement;

import java.util.ArrayList;

public class implement9 {
    public static void main(String[] args) {
        int n = 12;
        int[] weak = new int[]{1, 5, 6, 10};
        int[] dist = new int[]{1, 2, 3, 4};

        int result = solution(n, weak, dist);
        System.out.println(result);
    }

    static ArrayList<ArrayList<Integer>> distList = new ArrayList<>();
    static int[] now;

    public static int solution(int n, int[] weak, int[] dist) {
        ArrayList<Integer> weakList = new ArrayList<>();
        // 순서대로 넣기 위해 반복문 2번 시행
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i]);
        }
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i] + n);
        }

        int answer = dist.length + 1;
        now = new int[dist.length];

        // 모든 멤버 순서 가지수 구하기
        permutation(dist, 0, dist.length, dist.length);

        // 모든 취약점에서 시작하도록 시행
        for (int start = 0; start < weak.length; start++) {
            // 위에서 구한 멤버순서 가지수를 모두 시행
            for (int i = 0; i < distList.size(); i++) {
                int count = 1;
                int position = weakList.get(start) + distList.get(i).get(count - 1);
                // 다음 취약점 확인(현재 취약점부터 취약점의 수만큼 진행)
                for (int index = start; index < start + weak.length; index++) {
                    // 다음 취약점이 있으면
                    if (position < weakList.get(index)) {
                        count += 1;
                        // 인원 초과하면 멈춤
                        if (count > dist.length) {
                            break;
                        }
                        // 다음 위치 갱신
                        position = weakList.get(index) + distList.get(i).get(count - 1);
                    }
                }
                answer = Math.min(answer, count);
            }
        }

        if (answer > dist.length) {
            return -1;
        }

        return answer;
    }

    // Swap 순열 코드 - 각 depth 에 해당하는 자리의 수를 하나씩 고정하며 가능한 경우를 구함
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            distList.add(temp);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            now[depth] = arr[depth];
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
