package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2263 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] post = new int[n];
        int[] in = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }


        preorder(post, in, 0, n - 1, 0, n - 1);

        System.out.println(sb);

    }

    public static void preorder(int[] post, int[] in, int ps, int pe, int is, int ie) {
//        끝까지 도달한 경우 리턴
        if (ps > pe || is > ie) {
            return;
        }
//        postorder 의 맨 끝값이 root node 이다
        int parent = post[pe];
        sb.append(parent).append(" ");

//        inorder 에서 root node 에 해당하는 값 찾기
        int target = -1;
        for (int i = is; i <= ie; i++) {
            if(in[i] == parent) {
                target = i;
                break;
            }
        }

//        inorder 의 root node 기준으로 양옆으로 반복 진행
        preorder(post, in, ps, ps + target - is - 1, is, target - 1);
        preorder(post, in, ps + target - is, pe - 1, target + 1, ie);

    }
}
