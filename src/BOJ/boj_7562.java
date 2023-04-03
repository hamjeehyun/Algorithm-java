package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7562 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, sx, sy, ex, ey;
    static int[][] dist;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};
    static boolean[][] visit;

    static void input() {
        N = scan.nextInt();
        sx = scan.nextInt();
        sy = scan.nextInt();
        ex = scan.nextInt();
        ey = scan.nextInt();
        dist = new int[N][N];
        visit = new boolean[N][N];
    }

    static int bfs() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dist[i][j] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sx);
        queue.add(sy);
        visit[sx][sy] = true;
        dist[sx][sy] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

        return dist[ex][ey];
    }

    static void pro() {
        System.out.println(bfs());
    }

    public static void main(String[] args) {
        int T = scan.nextInt();

        while (T-- > 0) {
            input();
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
