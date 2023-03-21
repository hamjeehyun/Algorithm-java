package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2805 {
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

    static boolean determination(int H) {
        long sum = 0; // 자른 나무들의 길이
        for (int i = 1; i <= N; i++) {
            if (A[i] > H) { // 나무를 자를 수 있을 때
                sum += A[i] - H; // 자른 나무의 길이를 더하기
            }
        }
        return sum >= M; // 자른 나무의 길이의 합이 더 크면 true, 짧으면 false
    }

    static void pro() {
        long L = 0, R = 2000000000; // 나무의 길이 범위 설정 -> 탐색할 범위 설정
        long ans = 0; // 절단기에 설정할 수 있는 높이의 최댓값
        while (L <= R) {
            int mid = (int) ((L + R) / 2);
            if (determination(mid)) { // 자른 나무의 길이의 합이 더 크면 왼쪽으로 이동
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
