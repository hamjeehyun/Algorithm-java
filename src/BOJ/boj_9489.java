package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9489 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] a, par;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        a = new int[N + 1];
        par = new int[N + 1];
        for (int i = 1; i <= N; i++)
            a[i] = scan.nextInt();
    }

    static void pro() {
        par[0] = -1;
        par[1] = 0;

        int last = 1;
        for (int i = 2; i <= N; i++, last++) {
            for (; i <= N; i++) {
                par[i] = last;
                if (i < N && a[i] + 1 != a[i + 1])
                    break;
            }
        }

        int kIdx = 0;
        for (int i = 1; i <= N; i++)
            if (a[i] == K)
                kIdx = i;
        int ans = 0;
        for (int i = 1; i <= N; i++)
            if (par[par[i]] == par[par[kIdx]] && par[i] != par[kIdx])
                ans++;

        System.out.println(ans);
    }

    public static void main(String[] args) {
        while (true) {
            input();
            if (N == 0 && K == 0)
                break;
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
