package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1003 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] aD, bD;

    static void input() {
        N = scan.nextInt();
    }


    static void pro() {
        aD = new int[45];
        bD = new int[45];
        aD[0] = 1;
        aD[1] = 0;

        bD[0] = 0;
        bD[1] = 1;

        for (int i=2; i<=N; i++) {
            aD[i] = aD[i-1] + aD[i-2];
            bD[i] = bD[i-1] + bD[i-2];
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();

        while (T-- >0) {
            input();
            pro();
            sb.append(aD[N]).append(' ').append(bD[N]).append('\n');
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
