package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] X; // 집의 좌표

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        X = new int[N + 1];
        for (int i = 1; i <= N; i++) X[i] = scan.nextInt();
    }

    static boolean possible(int D) {
        int cnt = 1, last = X[1];

        for (int i = 2; i <= N; i++) {
            if (X[i] - last < D) continue;
            cnt++;
            last = X[i];
        }

        return cnt >= C;
    }

    static void solution() {
        Arrays.sort(X, 1, N + 1);

        int L = 0, R = 1000000000, ans = 0;
        while (L <= R) {
            int mid = (L + R) / 2;

            if (possible(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
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
