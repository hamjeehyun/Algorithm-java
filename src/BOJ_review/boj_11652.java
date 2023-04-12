package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11652 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] A;

    static void input() {
        N = scan.nextInt();
        A = new long[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextLong();
    }

    static void solution() {
        Arrays.sort(A, 1, N + 1);
        long mode = A[1];
        int modeCnt = 1, curCnt = 1;

        for (int i = 2; i <= N; i++) {
            if (A[i] == A[i - 1])
                curCnt++;
            else
                curCnt = 1;
            if (curCnt > modeCnt) {
                modeCnt = curCnt;
                mode = A[i];
            }
        }
        System.out.println(mode);
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

        long nextLong() {
            return Long.parseLong(next());
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
