package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20364 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static boolean[] estate;

    static void input() {
        N = scan.nextInt();
        Q = scan.nextInt();
        estate = new boolean[N + 1];
    }

    static void pro() {
        while (Q-- > 0) {
            int x = scan.nextInt();
            int y = x;
            int res = 0;

            while (x > 0) {
                if (estate[x]) res = x;
                x >>= 1;
            }
            estate[y] = true;
            sb.append(res).append('\n');
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
