package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15565 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void solution() {
        int R = 0, sum = 0, ans = -1;

        for (int L = 1; L <= N; L++) {
            while (R + 1 <= N && sum < K) {
                ++R;
                if (A[R] == 1) {
                    sum++;
                }
            }
            if (sum == K) {
                if (ans == -1) ans = R - L + 1;
                ans = Math.min(ans, R - L + 1); // 가장 작은 범위로 갱신
            }
            if (A[L] == 1) sum--;
        }

        System.out.println(ans);
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
