package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int row, col;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static boolean[][] visited;

    static int max = Integer.MIN_VALUE;

    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        for (int i = 0; i < row; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[row][col];


        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                ArrayList<Node> nodes = new ArrayList<>();
                nodes.add(new Node(i, j, graph.get(i).get(j)));
                search(nodes);
            }
        }


        System.out.println(max);

    }

    public static void search(ArrayList<Node> nodes) {
        if (nodes.size() == 4) {
            int sum = 0;
            for (Node node : nodes) {
                sum += node.val;
            }
            max = Math.max(max, sum);
            return;
        }

        ArrayList<Node> curNodes = (ArrayList<Node>) nodes.clone();
        for(Node node: curNodes){
            int curRow = node.row;
            int curCol = node.col;
            for (int i = 0; i < 4; i++) {
                int nRow = curRow + drow[i];
                int nCol = curCol + dcol[i];
                if (0 <= nRow && nRow < row && 0 <= nCol && nCol < col && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    Node nextNode = new Node(nRow, nCol, graph.get(nRow).get(nCol));
                    nodes.add(nextNode);
                    search(nodes);
                    nodes.remove(nextNode);
                    visited[nRow][nCol] = false;
                }
            }
        }
    }

    static class Node {
        int row,col, val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

}
