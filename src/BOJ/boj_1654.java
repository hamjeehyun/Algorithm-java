package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1654 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] A;

    static void input() {
        K = scan.nextInt(); // 가지고 있는 랜선의 개수
        N = scan.nextInt(); // 필요한 랜선의 개수
        A = new int[K + 1]; // 가지고 있는 각 랜선의 길이
        for (int i = 1; i <= K; i++) A[i] = scan.nextInt();
    }

    // len 만큼의 길이로 랜선들을 잘랐을 뗴, N개 만크의 랜서을 얻을 수 있는가?
    static boolean determination(long len) {
        long sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += A[i] / len;
        }
        return sum >= N; // 필요한 개수(N)보다 많으면 true
    }

    static void pro() {
        long L = 1, R = Integer.MAX_VALUE; // 탐색 범위
        long ans = 0;

        while (L <= R) {
            long mid = (L + R) / 2;
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
