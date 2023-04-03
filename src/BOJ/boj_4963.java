package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4963 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static void input() {
        M = scan.nextInt(); // 가로
        N = scan.nextInt(); // 세로
        a = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                a[i][j] = scan.nextInt();
        visit = new boolean[N][M];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (a[nx][ny] == 0) continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && a[i][j] == 1) {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        while (true) {
            input();
            if (N == 0 && M == 0) break;
            pro();
        }
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
