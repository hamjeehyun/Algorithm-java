package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int S, N, cnt = 0;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void solution(int k, int sum) {
        if (k == N + 1) {
            if (sum == S) cnt++;
        } else {
            solution(k + 1, sum + A[k]);
            solution(k + 1, sum);
        }
    }

    public static void main(String[] args) {
        input();
        solution(1, 0);
        if (S == 0) cnt--;
        System.out.println(cnt);
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

