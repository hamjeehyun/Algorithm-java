package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1764 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] A, ans;

    static void input() {
        N = scan.nextInt();
        A = new String[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextLine();
    }

    static boolean bin_search(String[] A, int L, int R, String X) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid].equals(X)) return true;

            if (A[mid].compareTo(X) < 0) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    static void pro() {
        int M = scan.nextInt(), ansCnt = 0;
        ans = new String[N + 1];
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            String X = scan.nextLine();
            if (bin_search(A, 1, M, X)) ans[++ansCnt] = X;
        }

        Arrays.sort(ans, 1, ansCnt + 1);
        sb.append(ansCnt).append('\n');
        for (int i = 1; i <= ansCnt; i++) sb.append(ans[i]).append('\n');
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
