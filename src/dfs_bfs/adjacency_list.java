package dfs_bfs;

import java.util.ArrayList;

public class adjacency_list {
    static class Node {
        int distance;
        int index;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public void show() {
            System.out.println("index = " + index + ", distance = " + distance);
        }
    }

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        graph.get(1).add(new Node(0, 7));

        graph.get(2).add(new Node(0, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }


    }
}
