package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1015 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Nums implements Comparable<Nums> {
        public int num, idx;

        @Override
        public int compareTo(Nums o) {
            return num - o.num;
        }
    }

    static int N;
    static Nums[] B;

    static void input() {
        N = scan.nextInt();
        B = new Nums[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Nums();
            B[i].num = scan.nextInt();
            B[i].idx = i;
        }
        int[] P = new int[N];
    }

    static void solution() {
        Arrays.sort(B);
        int[] P = new int[N];

        for (int i = 0; i < N; i++)
            P[B[i].idx] = i;

        for (int i = 0; i < N; i++)
            sb.append(P[i]).append(' ');
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
