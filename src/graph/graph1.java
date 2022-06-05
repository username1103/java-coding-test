package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
input
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
output
NO
NO
YES
 */
public class graph1 {
    static int studentCount, operationCount;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );

        studentCount = Integer.parseInt(st.nextToken());
        operationCount = Integer.parseInt(st.nextToken());

        parent = new int[studentCount + 1];
        for (int i = 1; i <= studentCount; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < operationCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int operation = Integer.parseInt(st.nextToken());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            if (operation == 0) {
                union(idx1, idx2);
            } else{
                if (findParent(idx1) == findParent(idx2)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }

    static int findParent(int x) {
        if(parent[x] != x){
            parent[x] = findParent(parent[x]);
        }

        return parent[x];
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
