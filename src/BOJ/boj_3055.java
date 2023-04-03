package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3055 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dist_water, dist_hedgehog;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][M];
        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];
    }

    static void bfs_water() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                dist_water[i][j] = -1;
                visit[i][j] = false;
                if (a[i].charAt(j) == '*') {
                    queue.add(i);
                    queue.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (a[nx].charAt(ny) != '.') continue;
                if (visit[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
            }
        }
    }

    static void bfs_hedgehog() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;
                if (a[i].charAt(j) == 'S') {
                    queue.add(i);
                    queue.add(j);
                    dist_hedgehog[i][j] = 0;
                    visit[i][j] = true;
                }
            }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (a[nx].charAt(ny) != '.' && a[nx].charAt(ny) != 'D') continue;
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1) continue;
                if (visit[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs_water();
        bfs_hedgehog();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (a[i].charAt(j) == 'D') {
                    if (dist_hedgehog[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(dist_hedgehog[i][j]);
                }
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
