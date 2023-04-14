package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10816 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        M = scan.nextInt();
        B = new int[M + 1];
        for (int i = 1; i <= M; i++) B[i] = scan.nextInt();
    }

    static int binarySearchStart(int L, int R, int X) {
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

    static int binarySearchEnd(int L, int R, int X) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] > X) {
                ans = mid;
                R = mid - 1;
            } else
                L = mid + 1;
        }

        return ans;
    }

    static void solution() {
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            int start = binarySearchStart(1, N, B[i]);
            int end = binarySearchEnd(1, N, B[i]);
            sb.append(end - start).append(' ');
        }
        System.out.println(sb.toString());
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
