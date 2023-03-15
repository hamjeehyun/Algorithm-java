package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1181 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length())
                return o1.length() - o2.length();
            return o1.compareTo(o2);
        }
    }

    static int N;
    static String[] words;

    static void input() {
        N = scan.nextInt();
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = scan.next();
        }
    }

    static void pro() {
        Arrays.sort(words, new MyComparator());

        for (int i = 0; i < N; i++) {
            if (i == 0 || words[i].compareTo(words[i - 1]) != 0) {
                sb.append(words[i]).append('\n');
            }
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

        public FastReader() {
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
