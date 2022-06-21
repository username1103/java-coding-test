package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1991 {
    static class Node {
        char self;

        Node left, right;

        public Node(char self) {
            this.self = self;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            nodes.add(new Node((char) ('A' + i)));
        }

        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            Node node = nodes.get(temp[0].charAt(0) - 'A');

            if(!temp[1].equals(".")){
                node.left = nodes.get(temp[1].charAt(0) - 'A');
            }

            if(!temp[2].equals(".")){
                node.right = nodes.get(temp[2].charAt(0) - 'A');
            }
        }

        preorder(nodes.get(0));
        System.out.println();
        inorder(nodes.get(0));
        System.out.println();
        postorder(nodes.get(0));
    }


    // 전위 순회
    static void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.self);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.self);
        inorder(node.right);
    }

    // 후위 순회
    static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.self);
    }


}
