package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_18404 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, sx, sy;
    static int[][] dist;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    static void input() {
        N = scan.nextInt(); // 체스판 크기
        M = scan.nextInt(); // 말의 개수
        sx = scan.nextInt(); // 시작점
        sy = scan.nextInt(); // 시작점
        dist = new int[N + 1][N + 1];
    }

    static void bfs() {
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                dist[i][j] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sx);
        queue.add(sy);
        dist[sx][sy] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx > N || ny > N) continue;
                if (dist[nx][ny] != -1) continue;

                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs();
        while (M-- > 0) {
            int ex = scan.nextInt();
            int ey = scan.nextInt();
            sb.append(dist[ex][ey]).append(' ');
        }
        System.out.println(sb);
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
