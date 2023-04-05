package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3584 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] par, check;

    static void input() {
        N = scan.nextInt();
        par = new int[N + 1];
        check = new int[N + 1];
        for (int i = 1; i < N; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            par[v] = u;
        }
    }

    static void pro() {
        int x = scan.nextInt();
        int y = scan.nextInt();

        while (x > 0) {
            check[x] = 1;
            x = par[x];
        }

        while (y > 0 && check[y] == 0) {
            y = par[y];
        }

        System.out.println(y);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
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
