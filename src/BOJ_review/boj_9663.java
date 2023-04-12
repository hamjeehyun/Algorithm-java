package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9663 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

    static void input() {
        N = scan.nextInt();
        visited = new boolean[N + 1][N + 1];
    }

    static void solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited[i][j] = true;
                for (int dir = 0; dir < 4; dir++) {

                }
            }
        }
    }

    public static void main(String[] args) {

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
