package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
input
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
output
3
input
4 2
1 3
2 4
3 4
output
-1
 */
public class sp1 {
    static final int INF = (int) 1e9;
    static int companyCount;
    static int pathCount;
    static int XCompany;
    static int KCompany;

    static int[][] graph = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        companyCount = Integer.parseInt(st.nextToken());
        pathCount = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= companyCount; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 1; i <= companyCount; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < pathCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int index1 = Integer.parseInt(st.nextToken());
            int index2 = Integer.parseInt(st.nextToken());

            graph[index1][index2] = 1;
            graph[index2][index1] = 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        XCompany = Integer.parseInt(st.nextToken());
        KCompany = Integer.parseInt(st.nextToken());

        for (int i = 1; i < companyCount + 1; i++) {
            for (int j = 1; j < companyCount + 1; j++) {
                for (int k = 1; k < companyCount + 1; k++) {
                    graph[j][k] = Math.min(graph[j][i] + graph[i][k], graph[j][k]);
                }
            }
        }

        int result = graph[1][KCompany] + graph[KCompany][XCompany];

        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }


    }
}
