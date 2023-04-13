package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_15970 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] A;

    static void input() {
        N = scan.nextInt();
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) A[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int idx = scan.nextInt();
            int color = scan.nextInt();
            A[color].add(idx);
        }
    }

    static int toLeft(int idx, int color) {
        if (idx == 0) return Integer.MAX_VALUE;
        return A[color].get(idx) - A[color].get(idx - 1);
    }

    static int toRight(int idx, int color) {
        if (idx == A[color].size() - 1) return Integer.MAX_VALUE;
        return A[color].get(idx + 1) - A[color].get(idx);
    }

    static void solution() {
        for (int color = 1; color <= N; color++)
            Collections.sort(A[color]);

        int ans = 0;
        for (int color = 1; color <= N; color++) {
            for (int j = 0; j < A[color].size(); j++) {
                ans += Math.min(toLeft(j, color), toRight(j, color));
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
