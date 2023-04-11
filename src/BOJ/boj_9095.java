package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9095 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] D;

    static void pro() {
        D = new int[15];

        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for(int i=4; i<=11; i++)
            D[i] = D[i-1] + D[i-2] + D[i-3];
    }

    public static void main(String[] args) {
        pro();

        int T = scan.nextInt();
        for(int i=0; i<T; i++) {
            int N = scan.nextInt();
            sb.append(D[N]).append(' ');
        }
        System.out.println(sb);
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
