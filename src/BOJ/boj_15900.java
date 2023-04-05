package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15900 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, sum_leaf_depth;
    static ArrayList<Integer>[] con;

    static void input() throws IOException {
        N = scan.nextInt();
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

    static void dfs(int x, int prev, int depth) {
        if (x != 1 && con[x].size() == 1)
            sum_leaf_depth += depth;
        for (int y : con[x]) {
            if (y == prev) continue;
            dfs(y, x, depth + 1);
        }
    }

    static void pro() {
        dfs(1, -1, 0);
        if (sum_leaf_depth % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }

    public static void main(String[] args) throws IOException {
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
