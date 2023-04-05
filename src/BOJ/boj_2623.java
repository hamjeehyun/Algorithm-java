package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_2623 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt(); // 가수의 수
        M = scan.nextInt(); // PD의 수
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int cnt = scan.nextInt(); // 담당한 가수의 수
            int x = scan.nextInt();
            int y;

            for (int j = 2; j <= cnt; j++) {
                // 각 PD의 가수 순서대로 입력
                y = scan.nextInt();
                adj[x].add(y);
                indeg[y]++;
                x = y;
            }
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            if (indeg[i] == 0)
                queue.add(i);

        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            ans.add(x);
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0)
                    queue.add(y);
            }
        }

        if (ans.size() == N)
            for (int x : ans)
                sb.append(x).append('\n');
        else sb.append(0);

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
