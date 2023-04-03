package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, H;
    static int[][][] dist, a;
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        a = new int[H + 1][N + 1][M + 1];
        dist = new int[H + 1][N + 1][M + 1];
        for (int h = 1; h <= H; h++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= M; j++)
                    a[h][i][j] = scan.nextInt();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int h = 1; h <= H; h++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= M; j++) {
                    dist[h][i][j] = -1;
                    if (a[h][i][j] == 1) {
                        dist[h][i][j] = 0;
                        queue.add(h);
                        queue.add(i);
                        queue.add(j);
                    }
                }

        while (!queue.isEmpty()) {
            int h = queue.poll();
            int i = queue.poll();
            int j = queue.poll();

            for (int k = 0; k < 6; k++) {
                int nh = h + dir[k][0];
                int ni = i + dir[k][1];
                int nj = j + dir[k][2];

                if (nh < 1 || ni < 1 || nj < 1 || nh > H || ni > N || nj > M) continue;
                if (dist[nh][ni][nj] != -1) continue;
                if (a[nh][ni][nj] == -1) continue;

                dist[nh][ni][nj] = dist[h][i][j] + 1;
                queue.add(nh);
                queue.add(ni);
                queue.add(nj);
            }
        }
    }

    static void pro() {
        bfs();
        int ans = 0;

        for (int h = 1; h <= H; h++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= M; j++) {
                    if (a[h][i][j] == -1) continue;
                    if (dist[h][i][j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, dist[h][i][j]);
                }
        System.out.println(ans);
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
