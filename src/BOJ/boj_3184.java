package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3184 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, totalSheep, totalWolf, sheep, wolf;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt(); // 행 - 가로
        M = scan.nextInt(); // 열 - 가로
        a = new String[N]; // 마당
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][M];
    }

    static void dfs(int x, int y) {
        if (a[x].charAt(y) == 'o') sheep++;
        if (a[x].charAt(y) == 'v') wolf++;

        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (a[nx].charAt(ny) == '#') continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && a[i].charAt(j) != '#') {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);

                    if (sheep > wolf) totalSheep += sheep;
                    else totalWolf += wolf;
                }
            }
        }
        sb.append(totalSheep).append(' ').append(totalWolf);
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
