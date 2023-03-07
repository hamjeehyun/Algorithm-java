package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15651 {
    static StringBuilder sb = new StringBuilder();
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[N + 1];
    }

    static int N, M;
    static int[] selected;


    static void rec_func(int k) {
        if (k == M + 1) {
            // 모아서 출력하기
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            // 다음 칸에 들어갈 숫자 계속 구하기
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;

                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

    public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next () {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt () {
            return Integer.parseInt(next());
        }
    }
}
