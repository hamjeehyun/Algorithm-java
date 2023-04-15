package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2343 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static boolean possible(int len) {
        int cnt = 1, sum = 0;

        // D 길이의 길이로 잘랐을 때 블루레이 수가 얼마나 나오는지?
        for (int i = 1; i <= N; i++) {
            if (sum + A[i] > len) {
                cnt++;
                sum = A[i];
            } else {
                sum += A[i];
            }
        }
        return cnt <= M;
    }

    static void solution() {
        int L = A[1], R = 1000000000, ans = 0;
        for (int i = 1; i <= N; i++) L = Math.max(A[i], L);

        while (L <= R) {
            int mid = (L + R) / 2;
            if (possible(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
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
