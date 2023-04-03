package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5567 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
        dist = new int[N + 1];
    }

    static int bfs(int start) {
        int sum = 0;
        for (int i = 1; i <= N; i++)
            dist[i] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (dist[x] >= 1 && dist[x] <= 2) sum++;
            if (dist[x] == 2) continue; // 중복된 것은 넘기기

            for (int y : adj[x]) {
                if (dist[y] != -1) continue;

                queue.add(y);
                dist[y] = dist[x] + 1;
            }
        }
        return sum;
    }

    static void pro() {
        System.out.println(bfs(1));
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
