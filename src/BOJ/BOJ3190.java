package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3190 {
    static int size;
    static int appleCount;
    static int cdCount;

    static int[] changeDirection = new int[10001];
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        board = new int[size + 1][size + 1];

        st = new StringTokenizer(br.readLine());
        appleCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < appleCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1;
        }

        st = new StringTokenizer(br.readLine());
        cdCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cdCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            changeDirection[time] = direction.equals("L") ? 1 : 2;
        }

        Snake snake = new Snake();
        int result = 0;
        while(snake.hasGo()){
            result += 1;
            snake.go(result);
        }

        System.out.println(result + 1);



    }

    static class Snake {
        public int length = 1;
        // 0: 북, 1: 동, 2: 남, 3: 서
        public int direction = 1;
        public int[] drow = {-1, 0, 1, 0};
        public int[] dcol = {0, 1, 0, -1};
        public int[] head = {1, 1};
        public Queue<int[]> body = new LinkedList<>() {
            @Override
            public boolean contains(Object o) {
                int[][] temp = new int[body.size()][2];
                temp = body.toArray(temp);

                for (int[] ints : temp) {
                    if (ints[0] == ((int[]) o)[0] && ints[1] == ((int[]) o)[1]) {
                        return true;
                    }
                }
                return false;
            }
        };

        public Snake() {
            int[] head = {1, 1};
            body.offer(head);
        }

        public void go(int time){
            int[] nextHead = {head[0] + drow[direction], head[1] + dcol[direction]};
            body.offer(nextHead);
            head = nextHead;
            if (board[nextHead[0]][nextHead[1]] == 1) {
                length += 1;
                board[nextHead[0]][nextHead[1]] = 0;
            } else {
                body.poll();
            }

            if (changeDirection[time] == 1) {
                direction = (direction + 3) % 4;
            } else if (changeDirection[time] == 2) {
                direction = (direction + 1) % 4;
            }
        }

        public boolean hasGo(){
            int[] nextHead = {head[0] + drow[direction], head[1] + dcol[direction]};
            return nextHead[0] >= 1 && nextHead[0] <= size && nextHead[1] >= 1 && nextHead[1] <= size && !body.contains(nextHead);
        }
    }
}
