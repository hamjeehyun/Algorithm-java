package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_20291 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] file;

    static void input() {
        N = scan.nextInt();
        file = new String[N + 1];
        for (int i = 1; i <= N; i++) file[i] = scan.nextLine().split("\\.")[1];
    }

    static void solution() {
        Arrays.sort(file, 1, N + 1);

        for (int i = 1; i <= N; ) {
            int cnt = 1;
            int j = i + 1;
            for (; j <= N; j++) {
                if (file[j].compareTo(file[i]) == 0) cnt++;
                else break;
            }

            sb.append(file[i]).append(' ').append(cnt).append('\n');
            i = j;
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
