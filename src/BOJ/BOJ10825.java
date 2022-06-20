package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10825 {
    static class Student implements Comparable<Student>{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (korean < o.korean) {
                return 1;
            } else if (korean > o.korean) {
                return -1;
            } else {
                if (english < o.english) {
                    return -1;
                } else if (english > o.english) {
                    return 1;
                } else {
                    if (math < o.math) {
                        return 1;
                    } else if (math > o.math) {
                        return -1;
                    } else {
                        return name.compareTo(o.name);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Student[] list = new Student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Student s :list) {
            sb.append(s.name).append("\n");
        }

        System.out.println(sb);
    }
}
