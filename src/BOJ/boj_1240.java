package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1240 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int y, c;

        Edge(int y, int c) {
            this.y = y;
            this.c = c;
        }
    }

    static int N, M;
    static ArrayList<Edge>[] con;
    static int ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        con = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            con[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int c = scan.nextInt();
            con[x].add(new Edge(y, c));
            con[y].add(new Edge(x, c));
        }
    }

    static void dfs(int x, int prev, int goal, int dist) {
        if (x == goal) {
            ans = dist;
            return;
        }

        for (Edge e : con[x]) {
            if (e.y == prev) continue;
            dfs(e.y, x, goal, dist + e.c);
        }
    }

    static void pro() {
        int x = scan.nextInt();
        int y = scan.nextInt();

        dfs(x, -1, y, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        while (M-- > 0) {
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
