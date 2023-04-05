package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1753 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info() {

        }

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N, M, K;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to, weight));
        }
    }

    static void dijstra(int start) {
        for (int i = 1; i <= N; i++)
            dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        queue.add(new Info(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            if (dist[info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                queue.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void pro() {
        dijstra(K);
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else sb.append(dist[i]).append('\n');
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
