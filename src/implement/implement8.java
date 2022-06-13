package implement;

import java.util.ArrayList;

public class implement8 {

    public static void main(String[] args) {
        int n = 5;
//        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

        int[][] result = solution(n, build_frame);
        for (int[] ints : result) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n, int[][] build_frame) {
        ArrayList<int[]> answer = new ArrayList<>();

        for (int[] frame : build_frame) {
            int col = frame[0];
            int row = frame[1];
            int type = frame[2];
            int action = frame[3];

            // 추가 또는 삭제
            if (action == 1) {
                answer.add(new int[]{col, row, type});
                if (!isValid(answer)) {
                    answer.remove(answer.size() - 1);
                }
            } else {
                remove(answer, new int[]{col, row, type});
                if (!isValid(answer)) {
                    answer.add(new int[]{col, row, type});
                }
            }
        }

        int[][] arrayAnswer = new int[answer.size()][3];
        answer.sort((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return o1[2] - o2[2];
                }
            }
        });
        arrayAnswer = answer.toArray(arrayAnswer);

        return arrayAnswer;
    }

    public static boolean isValid(ArrayList<int[]> answer) {

        for (int[] frame : answer) {
            int col = frame[0];
            int row = frame[1];
            int type = frame[2];

            // 기둥
            if (type == 0) {
                if (row == 0 || contain(answer, new int[]{col - 1, row, 1}) || contain(answer, new int[]{col, row - 1, 0}) || contain(answer, new int[]{col, row, 1})) {
                    continue;
                } else {
                    return false;
                }
            }
            // 보
            else {
                if (contain(answer, new int[]{col, row - 1, 0}) || contain(answer, new int[]{col + 1, row - 1, 0}) || (contain(answer, new int[]{col - 1, row, 1}) && contain(answer, new int[]{col + 1, row, 1}))) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void remove(ArrayList<int[]> answer, int[] arc) {
        for (int i = 0; i < answer.size(); i++) {
            int[] value = answer.get(i);
            if (value[0] == arc[0] && value[1] == arc[1] && value[2] == arc[2]) {
                answer.remove(i);
                break;
            }
        }
    }

    public static boolean contain(ArrayList<int[]> answer, int[] arc) {
        for (int[] value : answer) {
            if (value[0] == arc[0] && value[1] == arc[1] && value[2] == arc[2]) {
                return true;
            }
        }
        return false;
    }
}
