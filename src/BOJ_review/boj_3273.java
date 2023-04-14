package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3273 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, X;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        X = scan.nextInt();
    }

    static boolean binarySearch(int L, int R, int X) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == X) return true;
            else if (A[mid] < X)
                L = mid + 1;
            else
                R = mid - 1;
        }
        return false;
    }

    static void solution() {
        Arrays.sort(A, 1, N + 1);

        int cnt = 0;
        for (int i = 1; i <= N - 1; i++) {
            if (binarySearch(i + 1, N, X - A[i])) cnt++;
        }

        System.out.println(cnt);
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
