package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11728 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N+ 1];
        B = new int[M+1];
        for (int i = 1; i < N+1; i++) A[i] = scan.nextInt();
        for (int i = 1; i < M+1; i++) B[i] = scan.nextInt();
    }

    static void solution() {
        int L = 1, R = 1;
        while (L <= N && R <= M) {
            if(A[L] < B[R]) sb.append(A[L++]).append(' ');
            else sb.append(B[R++]).append(' ');
        }
        while (L <= N) sb.append(A[L++]).append(' ');
        while(R <= M) sb.append(B[R++]).append(' ');

        System.out.println(sb);
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
