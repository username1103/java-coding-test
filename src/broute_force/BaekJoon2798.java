package broute_force;

import java.io.*;
import java.util.*;

public class BaekJoon2798 {

    static int cardCount;
    static int maxNum;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        cardCount = Integer.parseInt(st.nextToken());
        maxNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        List<Integer> cards = new ArrayList<>(cardCount);

        for (int i = 0; i < cardCount; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        result = select(cards, 0, 3, 0);

        System.out.println(result);
    }

    static int select(List<Integer> cards, int idx, int select, int sumVal) {
        if (select == 0) {
            if (sumVal > result && sumVal <= maxNum) {
                return sumVal;
            }
            return result;

        }

        for (int i = idx; i < cardCount; i++) {
            sumVal += cards.get(i);
            result = select(cards, i + 1, select - 1, sumVal);
            sumVal -= cards.get(i);
        }

        return result;
    }

}