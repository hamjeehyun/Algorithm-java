package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15681 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, R, Q;
    static ArrayList<Integer>[] con;
    static int[] Dy;

    static void input() {
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        con = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            con[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            con[x].add(y);
            con[y].add(x);
        }
    }

    static void dfs(int x, int prev) {
        Dy[x] = 1;
        for (int y : con[x]) {
            if (y == prev) continue;
            dfs(y, x);
            Dy[x] += Dy[y];
        }
    }

    static void pro() {
        Dy = new int[N + 1];

        dfs(R, -1);

        for (int i = 1; i <= Q; i++) {
            int q = scan.nextInt();
            sb.append(Dy[q]).append('\n');
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
