package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10825 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem o) {
            // 국어 내림차순
            if (korean != o.korean) return o.korean - korean;

            // 영어 오름차순
            if (english != o.english) return english - o.english;

            // 수학 내림차순
            if (math != o.math) return o.math - math;

            return name.compareTo(o.name);
        }
    }

    static int N;
    static Elem[] students;

    static void input() {
        N = scan.nextInt();
        students = new Elem[N];

        for (int i = 0; i < N; i++) {
            students[i] = new Elem();
            students[i].name = scan.next();
            students[i].korean = scan.nextInt();
            students[i].english = scan.nextInt();
            students[i].math = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(students);

        for (int i = 0; i < N; i++) {
            sb.append(students[i].name).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
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
    }
}
