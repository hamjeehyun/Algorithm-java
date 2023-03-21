package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }


    static boolean bin_search(int[] A, int L, int R, int X) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == X) {
                return true;
            }
            if (A[mid] < X) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    static void pro() {
        int M = scan.nextInt();
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            int X = scan.nextInt();
            if (bin_search(A, 1, N, X)) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

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
    }
}
