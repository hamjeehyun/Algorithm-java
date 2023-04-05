package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_14267 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] Dy;
    static ArrayList<Integer>[] children;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        Dy = new int[N + 1];
        children = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            children[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int par = scan.nextInt();
            if (i == 1) continue;
            children[par].add(i);
        }
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int v = scan.nextInt();
            Dy[x] += v;
        }
    }

    static void dfs(int x) {
        for (int y : children[x]) {
            Dy[y] += Dy[x];
            dfs(y);
        }
    }

    static void pro() {
        dfs(1);
        for (int i = 1; i <= N; i++)
            sb.append(Dy[i]).append(' ');
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
