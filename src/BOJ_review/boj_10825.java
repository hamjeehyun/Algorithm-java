package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10825 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Student implements Comparable<Student> {
        public String name;
        public int kor, eng, math;

        @Override
        public int compareTo(Student o) {
            if (o.kor != kor) return o.kor - kor;
            if (o.eng != eng) return eng - o.eng;
            if (o.math != math) return o.math - math;
            return name.compareTo(o.name);
        }
    }

    static int N;
    static Student[] students;

    static void input() {
        N = scan.nextInt();
        students = new Student[N];
        for (int i = 0; i < N; i++) {
            students[i] = new Student();
            students[i].name = scan.next();
            students[i].kor = scan.nextInt();
            students[i].eng = scan.nextInt();
            students[i].math = scan.nextInt();
        }
    }

    static void solution() {
        Arrays.sort(students);
        for (int i = 0; i < N; i++) {
            sb.append(students[i].name).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solution();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
