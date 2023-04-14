package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2470 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static int lower_bound(int L, int R, int X) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                ans = mid;
                R = mid - 1;
            } else
                L = mid + 1;
        }

        return ans;
    }

    static void solution() {
        Arrays.sort(A, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        for (int i = 1; i <= N; i++) {
            int cand = lower_bound(i + 1, N, -A[i]);

            if (i < cand - 1 && Math.abs(A[i] + A[cand - 1]) < best_sum) {
                best_sum = Math.abs(A[i] + A[cand - 1]);
                v1 = A[i];
                v2 = A[cand - 1];
            }

            if (cand <= N && Math.abs(A[i] + A[cand]) < best_sum) {
                best_sum = Math.abs(A[i] + A[cand]);
                v1 = A[i];
                v2 = A[cand];
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
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
