package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static boolean determination(int D) {
        int cnt = 1, last = A[1];
        for (int i = 2; i <= N; i++) {
            int a = A[i];
            if (a - last < D) continue; // 거리 차이가 D 보다 작으면 넘기기
            // 거리차이가 D 이상일 경우에는
            last = A[i]; // 다음 집으로 옮기고
            cnt++; // 개수 세기

        }
        return cnt >= C;
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);
        int L = 1, R = 14; // 탐색해야하는 범위
        int ans = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
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
