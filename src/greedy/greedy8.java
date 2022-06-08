package greedy;

import java.util.*;

public class greedy8 {
    public static void main(String[] args) {
        int[] food_times = new int[]{3, 1, 2};
        int k = 5;
        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {

        if (Arrays.stream(food_times).asLongStream().sum() <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        long remainFoodCount = food_times.length;
        long totalTime = 0;
        long prevFoodTime = 0;


        while (totalTime + (pq.peek().time - prevFoodTime) * remainFoodCount <= k) {
            Food food = pq.poll();

            totalTime += (food.time - prevFoodTime) * remainFoodCount;
            remainFoodCount -= 1;
            prevFoodTime = food.time;
        }

        ArrayList<Food> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, Comparator.comparingInt(o -> o.index));


        return result.get((int) ((k - totalTime) % remainFoodCount)).index;
    }

    static class Food implements Comparable<Food> {
        int index, time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Food o) {
            return time - o.time;
        }
    }
}
