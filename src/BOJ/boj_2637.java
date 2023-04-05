package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_2637 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int y, v;

        Info(int y, int v) {
            this.y = y;
            this.v = v;
        }
    }

    static int N, M;
    static int[] indeg;
    static int[][] cnt;
    static ArrayList<Info>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        cnt = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int y = scan.nextInt();
            int x = scan.nextInt();
            int v = scan.nextInt();
            adj[x].add(new Info(y, v));
            indeg[y]++;
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            if (indeg[i] == 0) {
                queue.add(i);
                cnt[i][i] = 1;
            }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (Info info : adj[x]) {
                int y = info.y;
                int v = info.v;
                indeg[y]--;

                for (int i = 1; i <= N; i++)
                    cnt[y][i] += cnt[x][i] * v;

                if (indeg[y] == 0) queue.add(y);
            }
        }

        for (int i = 1; i <= N; i++)
            if (cnt[N][i] != 0)
                System.out.println(i + " " + cnt[N][i]);
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
