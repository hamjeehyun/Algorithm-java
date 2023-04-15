package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) A[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
        for (int i = 1; i <= N; i++) Collections.sort(A[i]);
        visited = new boolean[N + 1];
    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(' ');

        for (int y : A[x]) {
            if (visited[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');
            for (int y : A[x]) {
                if (visited[y]) continue;
                queue.add(y);
                visited[y] = true;
            }
        }
    }

    static void solution() {
        dfs(V);
        sb.append('\n');
        for (int i = 1; i <= N; i++) visited[i] = false;
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solution();
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
