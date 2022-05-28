package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
input
2
홍길동 95
이순신 77
output
이순신 홍길동
 */
public class sort2 {
    static int count;

    static class Student implements Comparable<Student> {
        private final int  score;
        private final String name;

        public Student(int score, String name) {
            this.score = score;
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            if (score < o.score) return -1;
            return 1;
        }
    }

    static List<Student> data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());
        data = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            data.add(new Student(score, name));
        }

        Collections.sort(data);

        for (Student s : data) {
            System.out.print(s.name + " ");
        }

    }
}
